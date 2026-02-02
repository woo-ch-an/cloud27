package com.ktdsuniversity.edu.generics;
				  // 인풋 줄게 아웃풋 주라
public interface Reducer<INPUT, OUTPUT> {
	
	OUTPUT reduce(INPUT input, OUTPUT output);
	
}
