package com.ktdsuniversity.edu.generics;

// Type
public class ScoreList<T, SUM_RESULT> {

	private Object[] scoreArray;

	private int size;

	public ScoreList() {
		this.scoreArray = new Object[2];
	}

	public void add(T score) {
		if (this.size >= this.scoreArray.length) {
			Object[] newArray = new Object[this.scoreArray.length + 2];

			System.arraycopy(this.scoreArray, 0, newArray, 0, this.scoreArray.length);

			this.scoreArray = newArray;

		}
		this.scoreArray[this.size++] = score;
	}

	public T get(int index) {
		if (this.size <= index) {
			// throw new IndexOutOfBoundsException();
		}

		T value = (T) this.scoreArray[index];
		return value;
	}

	public T sum() {
		// 배열에 들어 있는 모든 요소의 합을 반환

		T value = (T) this.scoreArray[0];
		return value;
	}
	
	public SUM_RESULT reultsum( Reducer<T, SUM_RESULT> reducer, SUM_RESULT defaultValue) {
		SUM_RESULT result = defaultValue;
		T t = null; 
		for (int i = 0; i < this.size; i++) {
			t = (T) this.scoreArray[i];
			result = reducer.reduce(t, result);
		}
		
		return result;
	}
	
	
}
