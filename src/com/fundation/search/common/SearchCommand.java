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

package fundation.search.common;

/**
 *
 Class SearchCommand command.
 *
 * @version 1.0
25 Mar 2018  * @author
J Christian Galarza Crespo  */

public class SearchCommand {
    /**
     * @param args the command line arguments.
     */
    public static void main(String[] args) {


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
            String dateString = new StringBuilder("").append("-d").toString();
            /* Declaration of commands

             * -v version
             * -f file
             * -p path
             * -t type
             * -s size
             * -o owner
             * -d date
             */
            //----------------------------------------------------------------------
            switch (args[i]){
                /*
                Command Version
                */
                case "-v":{
                    if(versionString.equals(versionString)){
                        System.out.println("Version program: 1.0.1 ");
                    }
                    break;
                }
                /*
                Command File
                */
                case "-f":{
                    if(fileString.equals(fileString)) {
                        String file;
                        if (args.length > 1) {
                            file = args[i + 1];
                            System.out.println(file + " file ");
                        } else {
                            System.out.println("please insert valid file");
                        }
                    }
                    break;
                }
                /*
                Command Size
                */
                case "-s":{
                    if(sizeString.equals(sizeString)){
                        String size;
                        if(args.length > 1) {
                            size = args[i + 1];
                            System.out.println(size + " Size ");
                        }else
                            System.out.println("please insert valid Size");
                    }
                    break;
                }
                /*
                Command Path
                */
                case "-p":{
                    if(pathString.equals(pathString)){
                        String path;
                        if (args.length > 1) {
                            path = args[i + 1];
                            System.out.println(path + " Path");
                        }else
                            System.out.println("please insert valid Patch");
                    }
                    break;
                }
                /*
                Command Type
                */
                case "-t":{
                    if(typeString.equals(typeString)){
                        String type;
                        if (args.length > 1) {
                            type = args[i + 1];
                            System.out.println(type + " Type ");
                        }else
                            System.out.println("please insert valid Type");
                    }
                    break;
                }
                /*
                Command Owner
                */
                case "-o":{
                    if(ownerString.equals(ownerString)){
                        String owner;
                        if (args.length > 1) {
                            owner = args[i + 1];
                            System.out.println(owner + " Owner ");
                        }else
                            System.out.println("please insert valid Owner");
                    }
                    break;
                }
                /*
                Command Date
                */
                case "-d":{
                    if(dateString.equals(dateString)){
                        String date;
                        if (args.length > 1) {
                            date = args[i + 1];
                            System.out.println(date + " Date ");
                        }else
                            System.out.println("please insert valid date");
                    }
                    break;
                }
                /*
                Command Help
                */
                case "-h":{
                    System.out.println("help ");
                    System.out.println("-v  version program " + '\n');
                    System.out.println("-f file type");
                    System.out.println("-p Path ");
                    System.out.println("-t type ");
                    System.out.println("-s Size ");
                    System.out.println("-o owner ");
                    System.out.println("-d date ");
                    break;
                }
                //--------------------------------------------------------------------
                /* Commands failed
                Command incomplete
                */
                case "-":{
                    System.out.println("Incomplete character try again");
                    break;
                }
            }
        }
    }
}
