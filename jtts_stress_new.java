import java.util.Calendar;
import java.util.Date;

import com.sinovoice.jTTS.JTTS_CONFIG;
import com.sinovoice.jTTS.jTTS_ML;
public class jtts_stress {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		int THREAD_MAX = 16;

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
   /*业务方法*/
           public  void tts_process_main(int x) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		calendar.add(Calendar.SECOND, 3*24*60*60);
		
/*		while(true){
			Date now = new Date();
			if(now.after(calendar.getTime())){
			break;
			}*/

                jTTS_ML jtts_java = new jTTS_ML();
                int nRet = jtts_java.jTTS_Init("10.0.1.66:1000","");
                System.out.println("jTTS_Init = " + nRet);

                JTTS_CONFIG config = new JTTS_CONFIG();
  /*              nRet = jtts_java.jTTS_Set(Config);
                System.out.println("jTTS_IniConfig = " + nRet);
                System.out.println("jTTS_IniConfig = " + Config.nCodePage);
                System.out.println("jTTS_IniConfig = " + Config.szVoiceID);*/
                config.nCodePage = (short)65001;
                config.szVoiceID="510D6500-B486-4767-8379-0EB59AB7AAAF";
        		config.wVersion = 4;
        		config.nCodePage = (short)65001;
        		//config.szVoiceID = "510D6500-B486-4767-8379-0EB59AB7AAAF";
        		config.nDomain = 0;
        		config.nSpeed = 5;
        		config.nPitch = 5;
        		config.nVolume = 8;
        		config.nDigitMode = 0;
        		config.nEngMode = 0;
        		//����nTagMode ����Nuance����ͱ�ά���⣬�ı����ޱ��ʱ����������ΪTAG_NONE 3�����⣬Nuance����ֻ֧��SSML��ǣ���ά����ֻ֧��VTML��ǡ�
        		config.nTagMode = 3;
        		config.nTryTimes = 10;
        		config.bLoadBalance = false;
        		config.nVoiceStyle = 0;
        		config.nBackAudioVolume = 0;
        		config.wBackAudioFlag = 0;
        		config.nInsertInfoSize = 100;	
        		config.nVoiceBufSize = 256;
			String	Text = "捷通华声tts语音播报技术捷通华声tts语音播报技术捷通华声tts语音播报技术捷通华声tts语音播报技术捷通华声tts语音播报技术捷通华声tts语音播报技术捷通华声tts语音播报技术捷通华声tts语音播报技术捷通华声tts语音播报技术捷通华声tts语音播报技术";
			String  Text1 = "捷通华声tts语音播报技术";
			//int i = 0 ; 
			Date now = new Date();
			int rd = Math.random()>0.5?1:0 ;
     while(true){
		if(now.after(calendar.getTime()))
                {
                    break;
                }
		if (rd == 0 ) {
		config.szVoiceID = "510D6500-B486-4767-8379-0EB59AB7AAAF";
		} else {
		config.szVoiceID = "B44D120D-A156-4b5b-A729-8E213EA27037";
		}
                //nRet = jtts_java.jTTS_PlayToFile("我爱你胜过我自己", "test"+x+".wav", jTTS_Java.FORMAT_WAV_8K16B,  Config,jtts_java.FORMAT_WAV_8K16B);
                nRet = jtts_java.jTTS_PlayToFile(Text, "./result_audio/"+x + ".wav", 6, config, (long)0, null, (long)0);
		
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

