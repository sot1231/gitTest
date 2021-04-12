package com.passion.eclass303.snsboard;

import java.util.List;

public interface SNSBoardMapper {
	public abstract int getAllSNSCount();
	public abstract List<SNSBoard> getSNS(SNSStartEnd se);
	public abstract int getSearchSNSCount(SNSStartEnd se);
	public abstract int writeSNSContent(SNSBoard snsb);
	public abstract int updateSNS(SNSBoard snsb);
	public abstract int deleteSNS(SNSBoard snsb);

	public abstract List<SNSReply> getReplys(SNSBoard snsb);
	public abstract int writeReply(SNSReply sr);
	public abstract int deleteSNSReply(SNSReply sr);
}
