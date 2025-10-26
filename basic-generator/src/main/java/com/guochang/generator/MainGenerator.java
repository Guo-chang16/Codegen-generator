package com.guochang.generator;

import cn.hutool.extra.template.TemplateException;
import com.guochang.generator.DynamicGenerator;
import com.guochang.generator.StaticGenerator;

import java.io.File;
import java.io.IOException;

public class MainGenerator {

    public static void doGenerate(Object model) throws IOException, TemplateException, freemarker.template.TemplateException {
        // 项目根目录
        String rootPath = System.getProperty("user.dir");

        // 静态文件生成
        String inputPath = rootPath + "/generator-demo-projects/acm-template";
        String outputPath = rootPath;

        // 验证静态模板目录
        File inputDir = new File(inputPath);
        if (!inputDir.exists()) {
            return;
        }

        // 复制静态文件
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        // 动态文件生成
        String inputDynamicFilePath = rootPath + "/basic-generator/src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = rootPath + "/generator-demo-projects/acm-template/src/com/yupi/acm/MainTemplate.java";

        // 验证动态模板文件
        File templateFile = new File(inputDynamicFilePath);
        if (!templateFile.exists()) {
            return;
        }

        // 确保输出目录存在
        File outputDir = new File(outputDynamicFilePath).getParentFile();
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        // 生成动态文件
        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }
}