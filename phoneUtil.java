
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;


/*class a{
	List<String> tmplist = phoneUtil.encryAllPhone(phonenums);
}*/

public class phoneUtil {

	public static void main(String[] args) {  
	//	String a = System.getProperty(args[1]);
	    String val = "13358484844";//~a76hqkggq8hqhh  
		trans.transfer("b.txt");
	    String result=encryptPhone(val);  
	    System.out.println(result);  
	    String rawdata=decryptPhone(val);  
	    System.out.println(rawdata);  
	}  
	  
	public static List<String> encryAllPhone(List<String> phonenums)
	{
		List<String> tmplist = new ArrayList();
		for(String i : phonenums)
		{
			tmplist.add(encryptPhone(i));
		}
		return tmplist;
	}
	 
	public static List<String> decryptAllPhone(List<String> phonenums)
	{
		List<String> tmplist = new ArrayList();
		for(String i : phonenums)
		{
			tmplist.add(decryptPhone(i));
		}
		return tmplist;
	}
	 
	
	/** 
	 * ���� 0 1 2 3 4 5 6 7 8 9 
	 * ��ĸ b a c g h k o w q p 
	 * @param val 
	 * @return ����ת��ĸ 
	 */  
	public static String getPhoneStr(String val) {  
	    String returnStr = "";  
	    if (val != null && val.length() > 0) {  
	        byte[] obj = val.getBytes();  
	        for (int i = 0; i < obj.length; i++) {  
	            returnStr += getLetter(String.valueOf(val.charAt(i)));  
	        }  
	    }  
	    return returnStr;  
	}  
	   /** 
	    * ��ĸת���� 
	    * ��ĸ b a c g h k o w q p 
	    * ���� 0 1 2 3 4 5 6 7 8 9 
	    * @param val 
	    * @return 
	    */  
	public static String getPhoneNum(String val){  
	    String returnStr = "";  
	    if (val != null && val.length() > 0) {  
	        byte[] obj = val.getBytes();  
	        for (int i = 0; i < obj.length; i++) {  
	            returnStr += getMapData().get(String.valueOf(val.charAt(i)));  
	        }  
	    }  
	    return returnStr;  
	}  
	  
	  
	  
	  
	/*** 
	 * ��λ�������������֣��ڶ�λ�͵���λ����������λ�͵���λ������λ���Ű����������� 
	 * 13510642584 
	 * 16015342584 
	 */  
	public static String changeNum(String val){  
	      
	    if(!UtilTools.isEmpty(val)){  
	        String str="";  
	        char [] phone=val.toCharArray();  
	        for(int i=0;i<phone.length;i++){  
	            if(i==1||i==2||i==4||i==5){  
	                if(i==1)  
	                    str+=phone[5];  
	                if(i==2)  
	                    str+=phone[4];  
	                if(i==4)  
	                    str+=phone[2];  
	                if(i==5)  
	                    str+=phone[1];  
	            }else{  
	                str+=phone[i];  
	            }  
	        }  
	        return str;  
	    }  
	    return val;  
	}  
	  
	/** 
	 * ͨ��Mapֵ��ȡkey 
	 * @return 
	 */  
	public static String getLetter(String val) {  
	    for(Entry<String,String> entry:getMapData().entrySet()){  
	        if(val.equals(entry.getValue()))  
	           return String.valueOf(entry.getKey());  
	    }  
	    return val;  
	}  
	  
	/** 
	 * ��ĸ b a c g h k o w q p 
	    * ���� 0 1 2 3 4 5 6 7 8 9 
	 * @return Map 
	 */  
	public static Map<String,String> getMapData(){  
	    Map<String,String> map = new HashMap<String,String>();  
	        map.put("b","0");  
	        map.put("a","1");  
	        map.put("c","2");  
	        map.put("g","3");  
	        map.put("h","4");  
	        map.put("k","5");  
	        map.put("o","6");  
	        map.put("w","7");  
	        map.put("q","8");  
	        map.put("p","9");  
	    return map;  
	}  
	  
	  
	  
	/** 
	 * �ַ���ǰ���ӡ�~�� 
	 */  
	public static String prefixStr(String val){  
	    return "~"+val;  
	}  
	  
	/** 
	 *  �����ַ���ǰ�ġ�~�� 
	 */  
	public static String filterStr(String val){  
	    if(val!=null&&val.indexOf("~")>-1){  
	        return val.substring(1,val.length());  
	    }  
	    if(val!=null&&val.indexOf("%")>-1){  
	        val=val.replace("%7E","~").replace("%7e","~");  
	        return val.substring(1,val.length());  
	    }  
	    return val;  
	}  
	  
	/** 
	 * ȥ���������� 
	 */  
	public static String removeNum(String val){  
	    return val.replaceAll("\\d+","");  
	}  
	  
	  
	/** 
	 * �������3������ 
	 */  
	public static String insertNum(String val){  
	    String num=radomNum(3);  
	    //��ָ�������ַ��������������  
	    for(int i=0;i<num.length();i++){  
	        Integer inNum= Integer.parseInt(radomNum(1));  
	        String result=val.substring(0,inNum>val.length()?val.length():inNum)+num.charAt(i)+val.substring(inNum>val.length()?val.length():inNum,val.length());  
	        val=result;  
	    }  
	    return val;  
	}  
	  
	  
	/** 
	 * �������iλ���� 
	 * i<10 
	 */  
	public static String radomNum(int i){  
	    Random random = new Random();  
	    String val=String.valueOf(random.nextInt());  
	    return val.substring(0,i).indexOf("-")>-1?radomNum(i):val.substring(0,i);  
	}  
	  
	  
	/** 
	 * �����ܲ��裺 
	 * 1����λ�������������֣��ڶ�λ�͵���λ����������λ�͵���λ���� 
	 * 2����ȫ������ת��Ϊ��Ӧ���ַ� 
	 * 3������λ�ò�������������� 
	 * 4���ڲ���C֮����ַ���ǰ���ϡ�~�� 
	 * @return 
	 */  
	public static String encryptPhone(String phoneStr){  
	    //1.��λ�������������֣��ڶ�λ�͵���λ����������λ�͵���λ����  
	    phoneStr=changeNum(phoneStr);  
	    //2.��ȫ������ת��Ϊ��Ӧ���ַ�  
	    phoneStr=getPhoneStr(phoneStr);  
	    //3.����λ�ò��������������  
	    phoneStr=insertNum(phoneStr);  
	    //4.�ڲ���C֮����ַ���ǰ���ϡ�~��  
	    phoneStr=prefixStr(phoneStr);  
	    return phoneStr;  
	}  
	  
	  
	/** 
	 * �����ܲ��裺 
	 * 1��ȥ���ַ���ǰ��~�� 
	 * 2��ȥ���������� 
	 * 3����ʣ����ĸȫ��ת��Ϊ��Ӧ������ 
	 * 4����λ�������������֣��ڶ�λ�͵���λ����������λ�͵���λ���� 
	 * @return 
	 */  
	public static String decryptPhone(String phoneStr){  
	    if(!UtilTools.isNumber(phoneStr)){  
	        //1.ȥ���ַ���ǰ��~��  
	        phoneStr=filterStr(phoneStr);  
	        //2.ȥ����������  
	        phoneStr=removeNum(phoneStr);  
	        //3.��ʣ����ĸȫ��ת��Ϊ��Ӧ������  
	        phoneStr=getPhoneNum(phoneStr);  
	        //4.��λ�������������֣��ڶ�λ�͵���λ����������λ�͵���λ����  
	        phoneStr=changeNum(phoneStr);  
	    }  
	    return phoneStr;  
	}  
	  
	        
	  
	   /** 
	    * ������ʽ������֤ 
	    *  
	    * @author crab 
	    * @param str 
	    * @return 
	    */  
	   public static boolean isNumber(String str) {  
	       if (str != null && !str.equals("")) {  
	           java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("[0-9]*");  
	           java.util.regex.Matcher match = pattern.matcher(str);  
	           return match.matches();  
	       } else {  
	           return false;  
	       }  
	   }  
	  
	   /** 
	    * �ַ����ǿշ�null�ж� crab 
	    */  
	   public static boolean isEmpty(String val) {  
	       if (val == null || val.equals("") || val.equalsIgnoreCase("null")) {  
	           return true;  
	       } else {  
	           return false;  
	       }  
	   }
}
class trans {


        public static void transfer(String args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args),"UTF-8"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("1.txt")),"UTF-8"));

        /* 读取数据 */
        try {
            String lineTxt = new String();
            while ((lineTxt = br.readLine()) != null) {

    			System.out.println(lineTxt+' '+"1");
                bw.write(lineTxt+" encryphone "+ phoneUtil.encryptPhone(lineTxt));
                bw.newLine();   //换行
            }
            br.close();
            bw.close();
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }
    }
}


class UtilTools {  
    public static boolean isNumber(String str) {  
        if (str != null && !str.equals("")) {  
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("[0-9]*");  
            java.util.regex.Matcher match = pattern.matcher(str);  
            return match.matches();  
        } else {  
            return false;  
        }  
    }  
    public static boolean isEmpty(String val) {  
        if (val == null || val.equals("") || val.equalsIgnoreCase("null")) {  
            return true;  
        } else {  
            return false;  
        }  
    }  
}