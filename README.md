# Code-Module

## 什么是代码模块

代码模块是采用去中心化的思想, 将代码块提取出来, 使用泛型或者高级父类, 使得代码块可以通用, 这些改造后的代码块被称为代码模块

## 项目组成

``sec/main/java``下是代码模块, 每一个代码模块都新建一个包, 每一个包下包含一个接口和实现类

``src/test/java``下是测试类, 每一个代码模块对应的测试类要以Test结尾命名, 可以存放一些用例