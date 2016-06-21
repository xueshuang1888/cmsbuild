package com.mingsoft.business.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mingsoft.base.action.BaseAction;
import com.mingsoft.base.constant.CookieConst;
import com.mingsoft.business.biz.ITuserBiz;
import com.mingsoft.business.entity.ReservationEntity;
import com.mingsoft.business.entity.TuserEntity;
import com.mingsoft.util.PageUtil;
/**
 * 
 * @ClassName: TuserAction
 * @Description: 系统注册用户控制类
 * @author:jk
 * @date: 2016年6月21日 下午5:47:23
 *
 */
@Controller("tuserAction")
@RequestMapping("/manager/tuser")
public class TuserAction extends BaseAction {
	@Autowired
	private ITuserBiz iTuserBiz;
	
	@RequestMapping("/list")
	public String list(@ModelAttribute("tuser") TuserEntity tuser,HttpServletRequest request, ModelMap mode, HttpServletResponse response){
		if (tuser==null) {
			tuser =  new TuserEntity();
		}
		// 查询数据表中记录集合总数
		int count = this.iTuserBiz.queryCountByCond(tuser);
		
		// 当前页面
		int pageNo = 1;
		// 获取页面的当页数
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		
		String url =  "/manager/reservation/list.do";
		// 分页集合
		PageUtil page = new PageUtil(pageNo, 20, count, getUrl(request) + url);
		// 实例化对象
		List<TuserEntity> tuserList = this.iTuserBiz.queryByPage(page, tuser);
		
		// 实例化对象
		mode.addAttribute("tuserList", tuserList);
		mode.addAttribute("page", page);	
		
		mode.addAttribute("articleShow", "");
		
		//将搜索的参数再传回页面
		mode.addAttribute("name", tuser.getName());
		mode.addAttribute("mobile", tuser.getMobile());
		
		// 返回路径
		this.setCookie(request, response, CookieConst.BACK_COOKIE,url+"&pageNo="+pageNo);
		return "manager/business/tuser/tuser_list";
	} 
	
	
	@RequestMapping("/editTuser")
	public String editTuser(@ModelAttribute("tuser") TuserEntity tuser,HttpServletRequest request, ModelMap mode, HttpServletResponse response){
		mode.addAttribute("tuser", tuser);
		return "manager/business/tuser/edit_tuser";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, String> saved(@ModelAttribute("tuser") TuserEntity tuser, HttpServletRequest request,HttpServletResponse response){
		
		Map<String, String> msgMap = new HashMap<String,String>();
		String msg = "";
		if (tuser.getName()==null||"".equals(tuser.getName())) {
			msg += "姓名不能为空\n";
		}
		if (tuser.getMobile()==null||"".equals(tuser.getMobile())) {
			msg += "手机号不能为空\n";
		}
		
		if (!"".equals(msg)) {
			msgMap.put("msgCode", "error");
			msgMap.put("msg", msg);
			return msgMap;
		}
		
		try {
			this.iTuserBiz.saveEntity(tuser);
			msgMap.put("msgCode", "success");
			msgMap.put("msg", "保存成功！");
		} catch (Exception e) {
			e.printStackTrace();
			msgMap.put("msgCode", "failur");
			msgMap.put("msg", "系统错误！");
		}	
		
		return msgMap;
	}
	
	@RequestMapping("/testPage")
	public String testPage(@ModelAttribute("tuser") TuserEntity tuser,HttpServletRequest request, ModelMap mode, HttpServletResponse response){
		mode.addAttribute("tuser", tuser);
		return "manager/business/tuser/edit_tuser";
	}
	
	
	@ModelAttribute("tuser")
	public TuserEntity getTuserEntity(@RequestParam(value="id",required=false)Integer id){
		TuserEntity tuser = null;
		if (id!=null&&id!=0) {
			tuser = this.iTuserBiz.getTuserEntity(id);
		}else{
			tuser = new TuserEntity();
			
		}
		
		return tuser;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
}
