package burp;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class BurpExtender implements IBurpExtender,ITab{ 
	public PrintWriter stdout;
    public IExtensionHelpers hps;
    public IBurpExtenderCallbacks cbs;

    public JPanel jPanelMain;

    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks)         {

        callbacks.setExtensionName("BurpExtender");

        this.hps = callbacks.getHelpers();
        this.cbs = callbacks;
        this.stdout = new PrintWriter(callbacks.getStdout(), true);

        this.stdout.println("hello burp!");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                jPanelMain = new JPanel();

                JButton jButton = new JButton("老司机,快点我!");

                jButton.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e){
                        stdout.println("哔...");
                    }

                });


                // 将按钮添加到 主面板 jPanelMain 中. 
                jPanelMain.add(jButton);

                // 设置自定义组件并添加标签
                cbs.customizeUiComponent(jPanelMain);
                cbs.addSuiteTab(BurpExtender.this);
            }
        });
    }

    // 实现 ITab 接口的 getTabCaption 方法
    @Override
    public String getTabCaption() {
        return "Burp 标签测试";
    }

    // 实现 ITab 接口的 getUiComponent 方法
    @Override
    public Component getUiComponent() {
        return jPanelMain;
    }
}







































