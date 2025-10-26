package com.guochang.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.guochang.generator.MainGenerator;
import com.guochang.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Data
@Command(name = "generate",mixinStandardHelpOptions = true)
public class GenerateCommand implements Callable<Integer> {

    @Option(names = {"-l","--loop"},description = "是否循环",arity = "0..1",interactive = true,prompt = "是否循环输入: ", echo = true)
    private boolean loop;

    @Option(names = {"-a","--author"},description = "作者名称",arity = "0..1",interactive = true,prompt = "输入作者名称: ", echo = true)
    private String author="chan";

    @Option(names = {"-o","--outPutText"},description = "输出内容",arity = "0..1",interactive = true,prompt = "输出最终文本: ", echo = true)
    private String outputText="e = ";

    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this, mainTemplateConfig);
        //mainTemplateConfig.setLoop(this.loop);
        //mainTemplateConfig.setAuthor(this.author);
        //mainTemplateConfig.setOutPutText(this.outPutText);
        System.out.println("配置信息：" + mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }

}
