package kylin.yimi.yiyi.mavenclean;

import java.io.File;

public class MavenFailFileClean {
	public static void main(String[] args) {
		String path=System.getProperty("maven.m2.path");
//		println(path);
//		Properties properties = System.getProperties();
		System.out.println("仓库地址"+path);
		File file  = new File(path);
		StringBuilder sb = new StringBuilder("已删文件列表:");
		delfilelist(file,sb);
		System.out.println(sb);
	}
	private static void delfilelist(File file,StringBuilder sb){
		if(!file.exists()){
			return ;
		}
		
		if(file.isFile()){
			String filename = file.getName();
			System.out.println("文件:"+filename);
			if(filename.endsWith("lastUpdated")){
				file.delete();
				System.out.println("删除文件:"+filename);
				sb.append(";"+filename);
			}
		}else{
			System.out.println("扫描文件夹："+file.getPath()+file.getName());
			for(File fi:file.listFiles()){
				delfilelist(fi,sb);
			}
		}
	}
}
