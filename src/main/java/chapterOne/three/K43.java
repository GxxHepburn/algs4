package chapterone.three;

import java.io.File;

import edu.princeton.cs.algs4.StdOut;

public class K43 {

	public static void main(String[] args) {
		String fp = "C:\\Users\\gxx\\Desktop\\Algorithms\\AlgA\\src\\main\\java";
		StdOut.println("fp");
		File file = new File(fp);
		Queue<String> queue = new Queue<String>();
		listFile(file, 1, queue);
		while (!queue.isEmpty()) {
			StdOut.println(queue.dequeue());
		}
	}
	
	public static void listFile(File file, int deep, Queue<String> queue) {
		File[] files = file.listFiles();
		String[] sfiles = file.list();
		String space = "";
		for (int i = 0; i < deep; i++) {
			space += " ";
		}
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				queue.enqueue(space + sfiles[i]);
				listFile(files[i], deep+1, queue);
			} else {
				queue.enqueue(space + sfiles[i]);
			}
		}
	}
}
