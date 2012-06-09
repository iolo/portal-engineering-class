package jnu.ce.bs.k.service;

public interface NoteService {

	void writeNote(String writer, String note);
	
	void deleteNoteByWriteNum(String write_num);
}
