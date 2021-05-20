package chapterone.four;

public class K13 {

	public static void main(String[] args) {
		/*
		 * a、	对象开销16字节、double属性8字节、int属性4字节，4个补充字节
		 * 			合计24字节
		 * b、	对象开销16字节，String引用8字节，Date引用8字节，double属
		 * 		性8字节
		 * 			合计40字节
		 * c、	对象开销16字节，int属性4字节，字符串数组引用8字节，4个补充字节，
		 * 		字符串数组24+8C字节（不包含字符串)
		 * 			合计56+8C字节
		 * d、	对象开销16字节，x属性8字节，y属性8字节
		 * 			合计32字节
		 * e、	对象开销16字节，min属性8字节，max属性8字节
		 * 			合计32字节
		 * f、	对象开销16字节，Interval1D引用x8字节，Interval1D引用y8字节,
		 * 		两个引用各32字节
		 * 			合计64字节
		 * g、	对象开销16字节,value属性8字节
		 * 			合计24字节
		 */
		Double x = Double.valueOf(2);
	}
}
