package org.breachy;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import static org.breachy.mainPageFrame.breachyLogo;

public class SoftwareListsFrame extends JFrame implements ActionListener {
    private JFrame frame;
    private JLabel label;
    private JComboBox<Option> options;
    public JButton returnButton = new JButton("Return");

    class Option {
        String title;
        String paragraph;

        public Option(String title, String paragraph) {
            this.title = title;
            this.paragraph = paragraph;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnButton) {
            frame.dispose();
            setVisible(false);
            mainPageFrame mainPage = new mainPageFrame();
            mainPage.openMainPage(mainPage,true);
        }
    }

    public void addActionEvent() {
        //Button that return to main page\
        returnButton.addActionListener(this);
    }

    public SoftwareListsFrame() {
        frame = new JFrame("OS Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(600, 150, 400, 550);
        frame.setResizable(false);
        frame.setIconImage(breachyLogo.getImage());


        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label, BorderLayout.CENTER);


        options = new JComboBox<>();
        options.addItem(new Option("Linux", "Linux is a free, open-source operating system that was first introduced in 1991 by Linus Torvalds. Unlike proprietary operating systems such as Microsoft Windows or macOS, the source code of Linux is available for anyone to use, modify, and distribute. Linux is based on Unix and is known for its stability, security, and versatility. It can run on a variety of hardware platforms, from personal computers to supercomputers, and is used by millions of people around the world for both personal and business purposes. One of the key strengths of Linux is its customization capability. Users can easily modify the look and feel of the operating system, as well as add or remove features to meet their specific needs. Linux is also known for its large repository of free, open-source software, making it a popular choice for users who want an affordable and high-quality operating system. In recent years, Linux has become increasingly popular in enterprise environments, with many businesses using it to run servers, workstations, and other critical infrastructure. Linux is also a popular choice for embedded systems, such as smart TVs, routers, and mobile devices. In conclusion, Linux is a highly versatile and powerful operating system that has become an important player in the technology industry. Whether you're a home user, a business, or a developer, Linux offers a wealth of benefits that make it a popular choice for a wide range of applications.\n" +
                "\n"));
        options.addItem(new Option("Windows", "Windows is an operating system designed by Microsoft. The operating system is what allows you to use a computer. Windows comes preloaded on most new personal computers (PCs), which helps to make it the most popular operating system in the world. Windows makes it possible to complete all types of everyday tasks on your computer. For example, you can use Windows to browse the Internet, check your email, edit digital photos, listen to music, play games, and do much more. Windows is also used in many offices because it gives you access to productivity tools such as calendars, word processors, and spreadsheets. Microsoft released the first version of Windows in the mid-1980s. There have been many versions of Windows since then, but the most recent ones include Windows 10 (released in 2015), Windows 8 (2012), Windows 7 (2009), Windows Vista (2007), and Windows XP (2001)."));
        options.addItem(new Option("MacOS", "macOS, previously known as OS X, is a proprietary operating system developed by Apple Inc. for its line of Mac computers. It is based on the Unix operating system and provides a graphical user interface (GUI) that is easy to use and highly intuitive. One of the key features of macOS is its user-friendly design, which includes a clean, modern interface that makes it easy to navigate and access all of your files, applications, and settings. The operating system is also known for its integration with Apple's suite of software and hardware, including the popular iTunes music and video player, the App Store for downloading and purchasing new software, and the iCloud service for storing and accessing your files from any device. macOS is designed to be highly secure, with built-in protection against malware and other security threats. It also includes a number of built-in technologies for keeping your Mac running smoothly, such as Time Machine for backing up your data and the Spotlight search tool for quickly finding what you need. Another key feature of macOS is its compatibility with a wide range of software, including both Apple-developed and third-party applications. Whether you're using your Mac for work or play, you'll find a wealth of software options to meet your needs. In conclusion, macOS is a highly capable and user-friendly operating system that provides a powerful and seamless computing experience. Whether you're a creative professional, a student, or simply someone looking for a reliable and secure computing platform, macOS is an excellent choice that delivers the performance, features, and ease of use you need."));
        options.addItem(new Option("Android","Android is a free and open-source operating system developed by Google for mobile devices, such as smartphones and tablets. It is based on the Linux operating system and was first released in 2008. One of the key features of Android is its user-friendly interface, which is designed to be highly customizable and easy to use. It also provides a rich app ecosystem through the Google Play Store, which offers millions of apps and games for users to download and install. Another key strength of Android is its versatility. The operating system can be used on a wide range of devices, from budget-friendly smartphones to high-end tablets and smartwatches. This has helped to make Android the most widely used operating system in the world, with over 2 billion active devices. In addition to its user-friendly interface and versatility, Android is also known for its security features. Google constantly updates the operating system to address security threats and vulnerabilities, and it provides users with the ability to install security updates as soon as they become available. In conclusion, Android is a powerful and flexible operating system that provides users with a rich app ecosystem and an intuitive, customizable interface. Whether you're looking for a new smartphone or tablet, or simply want to upgrade your existing device, Android is an excellent choice that offers the features, performance, and ease of use you need."));
        options.addItem(new Option("IOS","IOS is a proprietary operating system developed by Apple Inc. for its line of iPhone, iPad, and iPod Touch devices. It is known for its sleek and user-friendly design, as well as its integration with Apple's suite of software and hardware products. One of the key features of iOS is its highly intuitive interface, which makes it easy for users to navigate and access all of their apps, files, and settings. The operating system also provides a rich app ecosystem through the App Store, which offers over 2 million apps and games for users to download and install. Another key strength of iOS is its security features. Apple has a rigorous app review process that helps to ensure that all apps in the App Store are safe and secure to use. The operating system also includes a number of built-in security features, such as Touch ID and Face ID for secure device unlocking, and the ability to install security updates as soon as they become available. In addition to its user-friendly design and security features, iOS is also known for its performance. Apple devices are known for their smooth and fast performance, and the operating system is optimized to take full advantage of the hardware it runs on. In conclusion, iOS is a powerful and highly refined operating system that provides users with an intuitive and seamless computing experience. Whether you're looking for a new smartphone, tablet, or simply want to upgrade your existing device, iOS is an excellent choice that offers the features, performance, and security you need."));
        options.addItem(new Option("HarmonyOS","HarmonyOS is a microkernel-based, distributed operating system developed by Huawei Technologies. It was first introduced in August 2019 as an alternative to Google's Android operating system for Huawei's smartphones, but has since been expanded to include other types of devices, including smartwatches, tablets, and televisions. One of the key features of HarmonyOS is its cross-device compatibility, which allows developers to create apps that can run seamlessly on a wide range of devices, regardless of their form factor or underlying hardware. This helps to simplify app development and provides users with a consistent experience across all of their devices. Another key strength of HarmonyOS is its security features. The microkernel architecture helps to prevent security threats by limiting the attack surface and ensuring that critical system components are isolated from each other. Huawei has also added a number of built-in security features, such as app sandboxing and security enhancements for device-to-device communication. In addition to its cross-device compatibility and security features, HarmonyOS also provides a user-friendly interface that is designed to be highly customizable and easy to use. The operating system includes a number of built-in apps and services, such as a digital assistant, a file manager, and a media player. In conclusion, HarmonyOS is a new and highly promising operating system that aims to provide a seamless and secure computing experience across a wide range of devices. While it is still in its early stages of development, it has the potential to become a major player in the operating system market, especially as Huawei continues to expand its product line and gain a larger global market share."));
        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Option selected = (Option) options.getSelectedItem();
                label.setText("<html><div style='text-align: center;'>" + selected.paragraph + "</div></html>");

            }
        });

        JPanel panel = new JPanel();
        panel.add(options);
        frame.add(panel, BorderLayout.NORTH);
        panel.add(returnButton, BorderLayout.NORTH);

        frame.setVisible(true);
        panel.setBackground(InitialPage.color);
        frame.setBackground(InitialPage.color);
        addActionEvent();

    }
    public void setLayoutManager() {
        frame.setLayout(null);
    }
}




