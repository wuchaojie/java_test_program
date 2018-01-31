import java.util.Calendar;
import java.util.Date;
public class jtts_stress {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		int THREAD_MAX = 100;
	        for (int i = 0; i < THREAD_MAX; i++) {
        	MyThread  t = new MyThread("线程"+ i , i); 
        	t.start();
		}
	}

}
	

class MyThread extends Thread { 
	 public int x = 0; 
	 MyThread(String name, int x) { 
       	 super(name); 
         this.x = x; 
    } 

   	 public void run() {
	     User u = new User(); 
       	     u.tts_process_main(x); 
    	} 
}


class User { 
   //业务方法//
           public  void tts_process_main(int x) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		calendar.add(Calendar.SECOND, 3*24*60*60);
		
/*		while(true){
			Date now = new Date();
			if(now.after(calendar.getTime())){
			break;
			}*/
		//int i = 0 ;
                jTTS_Java jtts_java = new jTTS_Java();
                int nRet = jtts_java.jTTS_Init("10.0.1.66", 1000);
                System.out.println("jTTS_Init = " + nRet);

                jTTS_Config Config = new jTTS_Config();
                nRet = jtts_java.jTTS_IniConfig(Config);
                System.out.println("jTTS_IniConfig = " + nRet);
                System.out.println("jTTS_IniConfig = " + Config.nCodePage);
                System.out.println("jTTS_IniConfig = " + Config.szVoiceID);
                Config.nCodePage = 65001;
                Config.szVoiceID="510D6500-B486-4767-8379-0EB59AB7AAAF";
		Date now = new Date();
		String Text = "我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己我爱你胜过我自己";
     while(true){
		if(now.after(calendar.getTime()))
                {
                    break;
                }
                nRet = jtts_java.jTTS_PlayToFile(Text,jtts_java.PLAYCONTENT_TEXT,"thread"+x+".wav", jtts_java.PLAYTOFILE_ADDHEAD, jtts_java.FORMAT_WAV_8K16B, Config);
                System.out.println("jTTS_PlayToFile = " + nRet);
//                nRet = jtts_java.jTTS_End();
                System.out.println("jTTS_End = " + nRet);
		System.out.println(Thread.currentThread().getName() + "运行结束"  );
            }
     }
/**
    @Override 
    public String toString() { 
        return "User{" + 
                        "code='" + code + '\'' + 
                        ", cash=" + cash + 
                        '}'; 
    }
**/ 
}

