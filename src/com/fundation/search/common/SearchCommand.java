/*
 * @(#)FunSearch.java
 *
 * Copyright (c) Fundation Jala.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Fundation Jala. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Fundation Jala.
 */

package fundation.search.common;

/**
 *
 Class SearchCommand command.
 *
 * @version 1.0
25 Mar 2018  * @author
J Christian Galarza Crespo  */
import java.util.Scanner;
public class SearchCommand {
    /**
     * @param args the command line arguments.
     */
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        for (int i = 0; i < args.length; i++){
            /**
             * Convert the command of char to String for combine the commands easy.
             */
            String v = new StringBuilder("").append("-v").toString();
            String e = new StringBuilder("").append("-e").toString();
            String f = new StringBuilder("").append("-f").toString();
            String s = new StringBuilder("").append("-s").toString();
            String p = new StringBuilder("").append("-p").toString();
            String t = new StringBuilder("").append("-t").toString();
            String o = new StringBuilder("").append("-o").toString();
            String d = new StringBuilder("").append("-d").toString();
            /* Declaration of commands

             * -v version
             * -e enter
             * -f file
             * -p path
             * -t type
             * -s size
             * -o owner
             * -d date
             */
            switch (args[i]){
                case "-v":{
                    if(v.equals(v)){
                        System.out.println("Version program: 1.0 ");
                    }
                    break;
                }
                case "-e":{
                    if(e.equals(e)){
                        String str = args[i + 1];
                        System.out.println(str);
                    }
                    break;
                }
                case "-f":{
                    if(f.equals(f)){
                        System.out.println("File ");
                    }

                    break;
                }
                case "-s":{
                    if(s.equals(s)){
                        System.out.println("Size ");
                    }
                    break;
                }
                case "-p":{
                    if(p.equals(p)){
                        System.out.println("Path");
                    }
                    break;
                }
                case "-t":{
                    if(t.equals(t)){
                        System.out.println("Type ");
                    }
                    break;
                }
                case "-o":{
                    if(o.equals(o)){
                        System.out.println("Owner ");
                    }
                    break;
                }
                case "-d":{
                    if(d.equals(d)){
                        System.out.println("Date ");
                    }
                    break;
                }
                case "-h":{
                    System.out.println("help ");
                    System.out.println("-v  version program " + '\n');
                    System.out.println("-e print String ");
                    System.out.println("-f file type");
                    System.out.println("-p Path ");
                    System.out.println("-t type ");
                    System.out.println("-s Size ");
                    System.out.println("-o owner ");
                    System.out.println("-d date ");
                    break;
                }
                case "-":{
                    System.out.println("Incomplete character try again");
                    break;
                }
                default :{
                    System.out.println(" Command don't valid, Please press -h  ");
                    break;
                }
            }
            /*
            * combine the commands and verify that is valid
            * */
            String File = ( e + f);
            String Path = ( e + p);

        }
    }
}
