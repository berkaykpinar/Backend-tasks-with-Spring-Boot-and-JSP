package com.apparel.actions.controler;

import com.apparel.actions.forms.CampaignFeedbackForm;
import com.apparel.model.entity.catalog.CategoryModel;
import com.apparel.model.service.catalog.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/**/kampanyalar")
public class CampaignPageController extends BaseControl {
    private static final Logger logger = LoggerFactory.getLogger(CategoryPageControler.class);

    protected static final String CAMPAIGN_CODE_PATH_VARIABLE_PATTERN = "/{campaignCode:.*}";
    protected static final String SEND_FEEDBACK_FORM = "/addFeedback";
    protected static final String SEND_FEEDBACK_AJAX = "/addFeedbackAjax";

    @Resource
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String campaign(final Model model, final HttpServletRequest httpServletRequest, final HttpServletResponse response) {
        model.addAttribute("pageName", "Kampanyalar");
        return "/campaign";
    }

    @RequestMapping(value = CAMPAIGN_CODE_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
    public String campaignDetail(@PathVariable("campaignCode") final Integer campaignCode, final Model model,
                                 final HttpServletRequest httpServletRequest, final HttpServletResponse response) {

        model.addAttribute("pageName", "Kampanyalar");
        model.addAttribute("categoryCode", campaignCode);
        CategoryModel category = categoryService.findById(campaignCode);
        model.addAttribute("productList", category.getProducts());

        return "/campaignDetail";
    }

    @RequestMapping(value = SEND_FEEDBACK_FORM, method = RequestMethod.POST)
    public String sendFeedback(@ModelAttribute("SpringWeb") CampaignFeedbackForm campaignFeedbackForm, final Model model) {
        model.addAttribute("feedbackMessage", campaignFeedbackForm.getName().concat(" " + campaignFeedbackForm.getSurname()));

        return "/campaign";
    }

    @ResponseBody
    @RequestMapping(value = SEND_FEEDBACK_AJAX, method = RequestMethod.POST)
    public String getSendFeedbackAjax(@ModelAttribute("SpringWeb") CampaignFeedbackForm campaignFeedbackForm, final Model model) {

        return campaignFeedbackForm.getName().length() > 2 ? "success" : "error";
    }
}
