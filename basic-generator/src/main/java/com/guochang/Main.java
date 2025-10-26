package com.guochang;

import com.guochang.cli.CommandExecutor;

public class Main {
    public static void main(String[] args) {
        args = new String[]{"list"};
        CommandExecutor commandExecutor=new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}
