package com.maimai.springbootlast.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Filter;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-03-27 16:46
 **/
public class ExecuteGroovy {
    public Map<String,Object> filter(Map<String,Object> input) {

        Binding binding = new Binding();
        binding.setVariable("input", input);
        GroovyShell shell = new GroovyShell(binding);
        String filterScript = "def field = input.get('field')\n"
                + "if (input.field == 'buyer') { return ['losDataBusinessName':'losESDataBusiness3', 'esIndex':'potential_goods_recommend1']}\n"
                + "if (input.field == 'seller') { return ['losDataBusinessName':'losESDataBusiness4', 'esIndex':'potential_goods_recommend2']}\n";
        System.out.println(filterScript);
        Script script = shell.parse(filterScript);
        Object ret = script.run();
        System.out.println(ret);
        return (Map<String, Object>) ret;
    }
    public static String filter() {
        ExecuteGroovy routeRuleFilter = new ExecuteGroovy();
        Map<String, Object> input = new HashMap<>();
        input.put("field", "seller");
        Map<String, Object> output = routeRuleFilter.filter(input);
        return "true";
    }

    public static void main(String[] args) {
        filter();
    }
}
