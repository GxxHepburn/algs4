package chapterone.three;

/**
 * 回环数组实现
 * @author gxx
 *
 * @param <Item>
 */

/*
 * --------------------------------------------------------
 * 	public class RingBuffer<Item> implements Iterable<Item>
 * --------------------------------------------------------
 * 		boolean reset()		重新设置
 * 		int size()			大小
 * 		boolean put(Item x)	存入缓存
 * 		Item take()			读取
 * --------------------------------------------------------
 */

public class RingBuffer<Item> {
	
	private Item[] elements = null;
	private int writePos = 0;
	private int readPos = 0;
	public boolean flipped = false;
	
	public RingBuffer(int cap) {
		this.elements = (Item[]) new Object[cap];
	}
	
	public void reset() {
		this.writePos = 0;
		this.readPos = 0;
		this.flipped = false;
	}
	
	public int size() {
		return elements.length;
	}
	
	public boolean put(Item x) {
		if (!flipped) {
			if (writePos == size()) {
				writePos = 0;
				flipped = true;
				if (writePos < readPos) {
					elements[writePos++] = x;
					return true;
				} else {
					return false;
				}
			} else {
				elements[writePos++] = x;
				return true;
			}
		} else {
			if (writePos < readPos) {
				elements[writePos++] = x;
				return true;
			} else {
				return false;
			}
		}
	}
	
	public Item take() {
		if (!flipped) {
			if (readPos < writePos) {
				return elements[readPos++];
			} else {
				return null;
			}
		} else {
			if (readPos == size()) {
				readPos = 0;
				flipped = false;
				if (readPos < writePos) {
					return elements[readPos++];
				} else {
					return null;
				}
			} else {
				return elements[readPos++];
			}
		}
	}
}
