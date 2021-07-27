package guest.domain;

import java.util.List;

public class MessageListView {
	
	//Message를 3개씩 화면에 보이게 하기 
	
	//게시물 Message 객체 3개
	private List<Message> messageList;

	//전체 게시물의 개수를 가지는 변수 만들기 - 전체 게시물의 갯수를 알아야 페이징 번호를 알 수 있다.
	private int messageTotalCount;
	
	//현재 페이지의 번호
	private int currentPageNumber;
	
	//페이지의 개수 - Message를 3개씩 화면에 보이게 하기
	private int pageTotalCount;
	
	//한 페이지에 표현할 메시지의 개수 - 이 개수는 페이지의 개수를 결정한다.
	private int messageCountPerPage;
	
	//DB 에서 가져올 변수 (sql에서 limit 0,3 을 표현할 변수)
	private int firstRow;   //DB 게시물의 시작 위
	private int endRow;	    //DB 게시물의 마지막 위치
	
	
	//생성자 - 메소드로 계산해서 쓸 pageTotalCount 만 제외하고 만들기
	public MessageListView(List<Message> messageList, int messageTotalCount, int currentPageNumber,
			int messageCountPerPage, int firstRow, int endRow) {
		this.messageList = messageList;
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		calpageTotalCount();
		//calpageTotalCount가 실행될 때에는 위의 변수에 값이 들어가 있을 때이다.
	}


	private void calpageTotalCount() {
		if(this.messageTotalCount == 0) {
			this.pageTotalCount =0;
		}else {
			//전체 게시물을 세개씩 나눠주기.
			// 10/3 -> 3  만약 10%3 -> 3+1
			this.pageTotalCount = this.messageTotalCount/this.messageCountPerPage;
			if(this.messageTotalCount%this.messageCountPerPage>0) {
				this.pageTotalCount++;
			}
		}
	}


	// 값이 바뀌면 안되기 때문에 getter 만 만들기
	public List<Message> getMessageList() {
		return messageList;
	}


	public int getMessageTotalCount() {
		return messageTotalCount;
	}


	public int getCurrentPageNumber() {
		return currentPageNumber;
	}


	public int getPageTotalCount() {
		return pageTotalCount;
	}


	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}


	public int getFirstRow() {
		return firstRow;
	}


	public int getEndRow() {
		return endRow;
	}
	
	
	
	
}
