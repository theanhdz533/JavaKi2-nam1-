package karaoke.controller.admin;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import karaoke.domain.List;
import karaoke.model.ListDto;
import karaoke.service.ListService;

@Controller
@RequestMapping("admin/karaoke")
public class ListController {
	@Autowired
    ListService listService;
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("list", new ListDto());
		return "admin/karaoke/addOrEdit";
	}

	@RequestMapping("edit/{maBh}")
	public ModelAndView edit(ModelMap model, @PathVariable("maBh") Long maBh) {
		
		Optional<List> optional = listService.findById(maBh); 
		ListDto dto  = new ListDto();
		if (optional.isPresent()) {
			List entity = optional.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
			model.addAttribute("list", dto);
			return new ModelAndView("admin/karaoke/addOrEdit", model);
		}
		
		model.addAttribute("message", "Song is not exits!");
		return new ModelAndView("forward:/admin/karaoke", model);
		
	}

	@GetMapping("delete/{maBh}")
	public ModelAndView delete(ModelMap model, @PathVariable("maBh") Long maBh) {
		
		listService.deleteById(maBh);
		model.addAttribute("message", "deleted");
		return new ModelAndView("forward:/admin/karaoke", model);
		
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,@Valid @ModelAttribute("list") 
	ListDto dto, BindingResult result) {
		
		if (result.hasErrors()) {
			return new ModelAndView("admin/karaoke/addOrEdit");
		}
		
		List entity = new List();
		BeanUtils.copyProperties(dto, entity);
		listService.save(entity);
		
		model.addAttribute("message", "Song is save!");
		return new ModelAndView("redirect:/admin/karaoke/", model);
	}
	

	@GetMapping("")
	public String show(ModelMap model) {
		
	java.util.List<List> list = listService.findAll();
	
	model.addAttribute("lists1", list);
		return "admin/karaoke/list";
	}
	
	@GetMapping("home")
	public String search(ModelMap model, @RequestParam(name  = "tenBh", required = false) String tenBh) {
				
		java.util.List<List> list = null;
		if(StringUtils.hasText(tenBh)) {
			 list = listService.findByTenBhContaining(tenBh);
		}
		long dem=0;
		dem = listService.countByTenBhContaining(tenBh);
		if ( StringUtils.hasText(tenBh)==false || dem==0){
			return "admin/karaoke/zero";
		}
		model.addAttribute("lists1",list);
		return "admin/karaoke/list";
	}
	
	
	
	@GetMapping("infor/{maBh}")
	public ModelAndView showInfo(ModelMap model, @PathVariable("maBh") Long maBh) {
		Optional<List> optional = listService.findById(maBh); 
		ListDto dto  = new ListDto();
		if (optional.isPresent()) {
			List entity = optional.get();
			BeanUtils.copyProperties(entity, dto);;
   
			model.addAttribute("list", dto);
			return new ModelAndView("admin/karaoke/infor", model);
		}
		return new ModelAndView("forward:/admin/karaoke/infor", model);
	}
	
	@GetMapping("thongke")
	public ModelAndView thongke(ModelMap model) {
		
		long vang = listService.countByTheLoaiContaining("Nhạc vàng");
		long tre = listService.countByTheLoaiContaining("Nhạc trẻ");
		long ngoai = listService.countByTheLoaiContaining("Nhạc nước ngoài");
		long all = listService.countByTenBhContaining("");
		long khac = all - (vang+tre+ngoai);
		
		
		model.addAttribute("vang", vang);
		model.addAttribute("tre", tre);
		model.addAttribute("ngoai", ngoai);
		model.addAttribute("khac", khac);
		return new ModelAndView("/admin/karaoke/thongke", model);
		
	}
	

}
