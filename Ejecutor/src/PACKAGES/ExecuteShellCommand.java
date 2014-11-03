/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PACKAGES;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class ExecuteShellCommand {
 
	public String executeCommand(String command) {
 
		StringBuffer output = new StringBuffer();
                //String[] environment = {"ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe"};
		Process p;
		try {
			p = Runtime.getRuntime().exec(command,null,null);
			p.waitFor();
			BufferedReader reader = 
                            new BufferedReader(new InputStreamReader(p.getInputStream()));
 
                        String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return output.toString();
 
	}
 
}