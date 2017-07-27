package au.com.logsearch;

@Service ("logParseManager")
public class LogParseManagerImpl implements LogParseManager
{
     
    public String truncate(String logLine,int n)
    {
        String fxdStr = " ... (truncated) ... ";
		String finalStr="";
    
		if(n >= str.length()){
		   return str;
		}
		else if(n < fxdStr.length()){
		   return str;
		}
		else{
		  int i = fxdStr.length()+(str.length()-n);
		  int len = str.length() - i;
		  int prefixLen = len/2;
		  int postfixLen = len - prefixLen;     
		  
		  finalStr = str.substring(0,prefixLen) + fxdStr + str.substring(str.length()-postfixLen,str.length());
		  
		}
		return finalStr;
		}
}