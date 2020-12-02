<!--
 * @Description: Easy Rule 使用手册
 * @Version: 1.0
 * @Autor: x-one
 * @Date: 2020-12-02 15:47:27
 * @LastEditors: x-one
 * @LastEditTime: 2020-12-02 15:50:27
-->

# 创建规则引擎

``` java
    RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);

    RulesEngine fizzBuzzEngine = new DefaultRulesEngine(parameters);
```
