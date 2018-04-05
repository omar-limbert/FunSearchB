/*
 * @(#)SearchCommand.java
 *
 * Copyright (c) Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package fundation.search.view.ViewParameters;

/**
 *
 Class SearchCommand command.
 *
 * @version 1.0
25 Mar 2018  * @author J Christian Galarza Crespo - AT-[06].
 */

public class SearchCommand {
    /**
     * @param args the command line arguments.
     */

    /**
     * init in the main
     */
    public SearchCommand(){

    }

    /**
     * @param args the command line arguments.
     */
    public void searchCommand2(String[] args) {

        for (int i = 0; i < args.length; i++){
            /*
             * Convert the command of char to String for combine the commands easy.
             */
            String versionString = new StringBuilder("").append("-v").toString();
            String fileString = new StringBuilder("").append("-f").toString();
            String sizeString = new StringBuilder("").append("-s").toString();
            String pathString = new StringBuilder("").append("-p").toString();
            String typeString = new StringBuilder("").append("-t").toString();
            String ownerString = new StringBuilder("").append("-o").toString();
            String modifyDateString = new StringBuilder("").append("-dm").toString();
            String createDateString = new StringBuilder("").append("-dc").toString();
            /* Declaration of commands
             * -v version
             * -f file
             * -p path
             * -t type
             * -s size
             * -o owner
             * -dm modification date
             * -dc create date
             */
            switch (args[i]){
                /*
                Command Version -v
                */
                case "-v":{
                    //here verify the command enter is -v
                    if(versionString.equals(versionString)){
                        System.out.println("Version program: 1.0");
                    }
                    break;
                }
                /*
                Command File -f
                */
                case "-f":{
                    //here verify the command enter is -f
                    if(fileString.equals(fileString)) {
                        String file;
                        //  verify that don't enter a empty space after the command
                        if (args.length > 1) {
                            file = args[i + 1];
                            System.out.println(file + " File ");
                        } else {
                            System.out.println("please insert valid file");
                        }
                    }
                    break;
                }
                /*
                Command Size -s
                */
                case "-s":{
                    //here verify the command enter is -s
                    if(sizeString.equals(sizeString)){
                        String size;
                        //  verify that don't enter a empty space after the command
                        if(args.length > 1) {
                            size = args[i + 1];
                            System.out.println(size + " Size ");
                        }else {
                            System.out.println("please insert valid Size");
                        }
                    }
                    break;
                }
                /*
                Command Path -p
                */
                case "-p":{
                    //here verify the command enter is -p
                    if(pathString.equals(pathString)){
                        String path;
                        //  verify that don't enter a empty space after the command
                        if (args.length > 1) {
                            path = args[i + 1];
                            System.out.println(path + " Path");
                        } else{
                            System.out.println("please insert valid Patch");
                        }
                    }
                    break;
                }
                /*
                Command Type -t
                */
                case "-t":{
                    //here verify the command enter is -t
                    if(typeString.equals(typeString)){
                        String type;
                        //  verify that don't enter a empty space after the command
                        if (args.length > 1) {
                            type = args[i + 1];
                            System.out.println(type + " Type ");
                        } else{
                            System.out.println("please insert valid Type");
                        }
                    }
                    break;
                }
                /*
                Command Owner -o
                */
                case "-o":{
                    //here verify the command enter is -o
                    if(ownerString.equals(ownerString)){
                        String owner;
                        //  verify that don't enter a empty space after the command
                        if (args.length > 1) {
                            owner = args[i + 1];
                            System.out.println(owner + " Owner ");
                        }else{
                            System.out.println("please insert valid Owner");
                        }
                    }
                    break;
                }
                /*
                Command modification  Date -dm
                */
                case "-dm":{
                    //here verify the command enter is -dm
                    if(modifyDateString.equals(modifyDateString)){
                        String modifyDate;
                        //  verify that don't enter a empty space after the command
                        if (args.length > 1) {
                            modifyDate = args[i + 1];
                            System.out.println(modifyDate + " Modification  Date ");
                        }else{
                            System.out.println("Please insert valid date");
                        }
                    }
                    break;
                }
                /*
                Command Create Date -dc
                */
                case "-dc":{
                    //here verify the command enter is -dc
                    if(createDateString.equals(createDateString)){
                        String createDate;
                        //  verify that don't enter a empty space after the command
                        if (args.length > 1) {
                            createDate = args[i + 1];
                            System.out.println(createDate + " Create Date ");
                        } else{
                            System.out.println("please insert valid date");
                        }
                    }
                    break;
                }
                /*
                Command Help -h
                */
                case "-h":{
                    //here verify the command enter is -h
                    System.out.println("help ");
                    System.out.println("-v  version program " + '\n');
                    System.out.println("-f file type");
                    System.out.println("-p Path ");
                    System.out.println("-t type ");
                    System.out.println("-s Size ");
                    System.out.println("-o owner ");
                    System.out.println("-dm modification date ");
                    System.out.println("-dc Create date ");
                    break;
                }
                /*
                 *Command failed
                 *Command incomplete -
                 */
                case "-": {
                    //here verify the command enter is incomplete
                    System.out.println("Incomplete character try again");
                    break;
                }
            }
        }
    }

}
