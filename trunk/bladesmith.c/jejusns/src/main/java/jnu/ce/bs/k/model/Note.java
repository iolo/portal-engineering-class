package jnu.ce.bs.k.model;

public class Note {
	private String write_num;
	private String writer;
	private String note;
	private String write_date;

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

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}

	public String getWrite_num() {
		return write_num;
	}

	public void setWrite_num(String write_num) {
		this.write_num = write_num;
	}
}
