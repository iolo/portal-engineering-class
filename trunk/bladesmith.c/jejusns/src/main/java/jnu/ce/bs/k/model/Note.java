package jnu.ce.bs.k.model;

public class Note {
	private String index;
	private String writer;
	private String note;
	private String writeDate;

	public Note() {

	}

	public Note(String writer, String note) {
		this.setWriter(writer);
		this.setNote(note);
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getIndexNum() {
		return index;
	}

	public void setIndexNum(String indexNum) {
		this.index = indexNum;
	}
}
