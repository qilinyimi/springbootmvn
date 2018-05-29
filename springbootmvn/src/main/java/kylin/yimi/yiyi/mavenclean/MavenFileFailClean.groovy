package kylin.yimi.yiyi.mavenclean
/***
 * groovy 可以没有类和main方法声明，这里我不知道怎么接受args参数
 */
//class MavenFileFailClean {
//	public static void main(String [] args){
//		String path = "";
	    String path=System.getProperty("maven.m2.path");
		println path;
		File file  = new File(path);
		delfilelist(file);
		
//		System.out.println(path);
//	}
	def   delfilelist(File file){
//		file = (File) file;
		if(!file.exists()){
			return ;
		}
		if(file.isFile()){
			String filename = file.getName();
			if(filename.endsWith("lastUpdated")){
				println "删除文件："+filename;
				file.delete();
			}else println "扫描文件："+filename;
		}
		else{
			println "扫描文件夹："+file.getPath()
			file.listFiles().collect{files->delfilelist(files)};
			}
	}
//}
