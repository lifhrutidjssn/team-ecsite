package jp.co.internous.team2411.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.team2411.model.domain.MstProduct;
import jp.co.internous.team2411.model.mapper.MstProductMapper;
import jp.co.internous.team2411.model.session.LoginSession;

/**
 * 商品情報の詳細に関する処理を行うコントローラー
 * @author インターノウス
 *
 */
@Controller
@RequestMapping("/team2411/product")
public class ProductController {

	@Autowired
	private MstProductMapper productMapper;
	
	@Autowired
	private LoginSession loginSession;

	/**
	 * 商品詳細画面を初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return 商品詳細画面
	 */
	@RequestMapping("/{id}")
	public String index(@PathVariable("id") int id, Model m) {

		MstProduct product = productMapper.findById(id);
		m.addAttribute("product", product);
		m.addAttribute("loginSession", loginSession);
		return "product_detail";
	}
}
