package org.xsk.easyrule.client;

import java.io.FileReader;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.xsk.easyrule.rule.RuleClass;
import org.xsk.easyrule.rule.RuleClass.BuzzRule;
import org.xsk.easyrule.rule.RuleClass.FizzRule;
import org.xsk.easyrule.rule.RuleClass.NonFizzBuzzRule;

/*
 * 
 * @Description: 
 * 
 * @Version: 1.0
 * 
 * @Autor: x-one
 * 
 * @Date: 2020-12-01 15:36:56
 * 
 * @LastEditors: x-one
 * @LastEditTime: 2020-12-02 15:17:23
 */
@Component
public class RuleClient {

    public static void main(String[] args) {
        ymlTest();
    }

    public static void general(){
        // create a rules engine
        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
        RulesEngine fizzBuzzEngine = new DefaultRulesEngine(parameters);

        // create rules
        Rules rules = new Rules();
        rules.register(new FizzRule());
        rules.register(new BuzzRule());
        rules.register(new RuleClass.FizzBuzzRule(new RuleClass.FizzRule(), new RuleClass.BuzzRule()));
        rules.register(new NonFizzBuzzRule());

        // fire rules
        Facts facts = new Facts();
        for (int i = 1; i <= 100; i++) {
            facts.put("number", i);
            fizzBuzzEngine.fire(rules, facts);
            System.out.println();
        }
    }

    public static void ymlTest(){
        // create a rules engine
        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
        RulesEngine fizzBuzzEngine = new DefaultRulesEngine(parameters);
        
        // create rules
        Rules rules = null;
        try {
            // String root = System.getProperty("user.dir");
            // String filePath = root + File.separator + "rule" + File.separator + "rule.yml";
            Resource resource = new ClassPathResource("/rule/rule.yml");
            rules = MVELRuleFactory.createRulesFrom(new FileReader(resource.getFile()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // fire rules
        Facts facts = new Facts();
        for (int i = 1; i <= 100; i++) {
            facts.put("number", i);
            fizzBuzzEngine.fire(rules, facts);
            System.out.println();
        }
    }
}

