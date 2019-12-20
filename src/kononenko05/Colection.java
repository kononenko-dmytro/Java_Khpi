package ua.khpi.oop.kononenko05;

import java.util.Iterator;


public class Colection{
	private String[] arr;
	private int size;
	
	public Colection(String[] mas){
        this.arr = mas;
        this.size = mas.length;
    }
	
	public String getElement(int index) {
		if(index > size || arr == null) {
			return "Error: invalid index";
		}
		
		return this.arr[index];
	}
	
	public String toString() {
		String str;
		StringBuffer temp = new StringBuffer();
		
		for(int i = 0; i < size; i++) {
			temp.append(arr[i]);
			temp.append(" ");
		}
		
		str = temp.toString();
		
		return str;
	};
	
	public void add(String obj) {
		
		
		int i;
		int j = 0;
		
		size++;
		String mas[] = new String[size];
		for (i = 0; i < size-1; i++) {
					mas[i] = this.arr[j];
			j++;
		}
		mas[size-1] = obj;

		arr = mas;
	}
	
	public void clear() {
		for(int i = 0; i < size; i++) {
			this.arr[i] = null;
		}
		size = 0;
	}
	
	private void delete(int index) {
		int j = 0;

		size--;;;
		String[] mas = new String[size];
		for (int i = 0; i < index; i++) {
			mas[i] = arr[j];
			j++;
		}
		j++;
		
		for (int i = index; i < size; i++) {
			mas[i] = arr[j];
			j++;
		}
		arr = mas;
	}
	
	public void remove(String str) {
		;
		for(int i = 0; i < size;i++) {
			if(this.arr[i].equals(str)) { 
				delete(i);
				return;
			}
		}
		
	}

	public int size() {
		return size;
	}

	public boolean contains(String str) {
		
		for(int i = 0; i < size;i++) {
			if(this.arr[i].equals(str)) { 
				return true;
			};
		}
		return false;
	}

	public boolean containsAll(Colection container) {
		boolean test = false;
		
		for(int i = 0; i < size;i++) {
			if(!this.arr[i].equals(container.arr[i])) { 
				return test;
			}
		}
		
		test = true;
		
		return test;
	}

	public String[] toArray() {
		return arr;
	}


	 public class Iteranator implements Iterator<String>{
		   private int index = 0;

         @Override
         public boolean hasNext() {
        	 if(index < size && arr[index] != null) {
        		 return true;
        	 }
        	 return false;
         }

         @Override
         public String next() {
             return arr[index++];
         }

         @Override
         public void remove() {
             throw new UnsupportedOperationException();
         }
	    }
	
	public Iterator<String> iterator() {
		return new Iteranator();
	}
}

