package utils;

public class DESUntil {  
    
    /** 
     * 使用默认密钥进行DES加密 
     */  
    public static String encrypt(String plainText) {  
        try {  
            return new DES().encrypt(plainText);  
        } catch (Exception e) {  
            return null;  
        }  
    }  
  
      
    /** 
     * 使用指定密钥进行DES解密 
     */  
    public static String encrypt(String plainText, String key) {  
        try {  
            return new DES(key).encrypt(plainText);  
        } catch (Exception e) {  
            return null;  
        }  
    }  
      
  
    /** 
     * 使用默认密钥进行DES解密 
     */  
    public static String decrypt(String plainText) {  
        try {  
            return new DES().decrypt(plainText);  
        } catch (Exception e) {  
            return null;  
        }  
    }  
  
      
    /** 
     * 使用指定密钥进行DES解密 
     */  
    public static String decrypt(String plainText, String key) {  
        try {  
            return new DES(key).decrypt(plainText);  
        } catch (Exception e) {  
            return null;  
        }  
    }  
    public static void main(String[] args) throws Exception {  
        String str = "01234ABCDabcd!@#$";  
        String t = "";  
        System.out.println("加密后：" + (t = DESUntil.encrypt(str)));  
        System.out.println("解密后：" + DESUntil.decrypt(t));  
    }  
  
}  
