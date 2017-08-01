package burp;

import java.io.PrintWriter;



public class BurpExtender implements IBurpExtender, IHttpListener{
	private PrintWriter stdout;
	public IBurpExtenderCallbacks icallbacks;
	@Override
	public void registerExtenderCallbacks(final IBurpExtenderCallbacks callbacks) {
		this.stdout = new PrintWriter(callbacks.getStdout(),true);
		callbacks.setExtensionName("Her0in");//设置扩展名称 "Her0in"
		callbacks.registerHttpListener(this);
	}

	@Override
	public void processHttpMessage(int toolFlag, boolean messageIsRequest,
			IHttpRequestResponse messageInfo) {
		IHttpService iHttpService = messageInfo.getHttpService();
		
		this.stdout.print(iHttpService.getHost());
		this.stdout.print(iHttpService.getPort());
		this.stdout.print(iHttpService.getProtocol());
	} 
	
}







































