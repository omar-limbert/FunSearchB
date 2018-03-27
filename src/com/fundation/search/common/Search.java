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
 Class Search command.
 *
 * @version 1.0
25 Mar 2018  * @author
J Christian Galarza Crespo  */

public class Search {
    /**
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        /* -v version
         * -e enter
         * -f file
         * -p path
         * -t type
         * -s size
         * -o owner
         * -d date
         */
        for (int i = 0; i < args.length; i++){
            switch (args[i]){
                case "-v":{
                    System.out.println("Version program: 1.0 ");
                    break;
                }
                case "-e":{
                    String str = args[i + 1];
                    System.out.println(str);
                    break;
                }
                case "-f":{
                    System.out.println("File ");
                    break;
                }
                case "-p":{
                    System.out.println("Path");
                    break;
                }
                case "-t":{
                    System.out.println("Type ");
                    break;
                }
                case "-s":{
                    System.out.println("Size ");
                    break;
                }
                case "-o":{
                    System.out.println("Owner ");
                    break;
                }
                case "-d":{
                    System.out.println("Date ");
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
                default :{
                    System.out.println(" Command don't valid, Please press -h  ");
                    break;
                }
            }
        }
    }
}
