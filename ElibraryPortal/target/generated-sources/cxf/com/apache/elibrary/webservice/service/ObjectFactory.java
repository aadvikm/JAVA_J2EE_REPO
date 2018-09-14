
package com.apache.elibrary.webservice.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.apache.elibrary.webservice.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetBookAndStudentListResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "getBookAndStudentListResponse");
    private final static QName _GetBookAndStudentList_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "getBookAndStudentList");
    private final static QName _SaveAdminResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "saveAdminResponse");
    private final static QName _DeleteLibrarianResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "deleteLibrarianResponse");
    private final static QName _SaveBook_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "saveBook");
    private final static QName _SaveLibrarian_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "saveLibrarian");
    private final static QName _ElibraryException_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "ElibraryException");
    private final static QName _DeleteAdminResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "deleteAdminResponse");
    private final static QName _UpdateAdmin_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "updateAdmin");
    private final static QName _GetBook_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "getBook");
    private final static QName _ReturnBookFormDetailResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "returnBookFormDetailResponse");
    private final static QName _GetBookResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "getBookResponse");
    private final static QName _DeleteLibrarian_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "deleteLibrarian");
    private final static QName _GetLibrarian_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "getLibrarian");
    private final static QName _GetAdmin_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "getAdmin");
    private final static QName _ReturningBookResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "returningBookResponse");
    private final static QName _GetAllIssuedBooksResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "getAllIssuedBooksResponse");
    private final static QName _AuthenticateAdmin_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "authenticateAdmin");
    private final static QName _SaveBookResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "saveBookResponse");
    private final static QName _ReturnBookFormDetail_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "returnBookFormDetail");
    private final static QName _UpdateBookResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "updateBookResponse");
    private final static QName _AuthenticateLibrarian_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "authenticateLibrarian");
    private final static QName _ReturningBook_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "returningBook");
    private final static QName _UpdateBook_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "updateBook");
    private final static QName _UpdateAdminResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "updateAdminResponse");
    private final static QName _SaveLibrarianResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "saveLibrarianResponse");
    private final static QName _UpdateLibrarian_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "updateLibrarian");
    private final static QName _SaveStudentBookDetailResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "saveStudentBookDetailResponse");
    private final static QName _AuthenticateLibrarianResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "authenticateLibrarianResponse");
    private final static QName _SaveStudentBookDetail_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "saveStudentBookDetail");
    private final static QName _GetAdminResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "getAdminResponse");
    private final static QName _GetAllBooksResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "getAllBooksResponse");
    private final static QName _AuthenticateAdminResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "authenticateAdminResponse");
    private final static QName _SaveAdmin_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "saveAdmin");
    private final static QName _GetLibrariansResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "getLibrariansResponse");
    private final static QName _GetLibrarians_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "getLibrarians");
    private final static QName _GetAllIssuedBooks_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "getAllIssuedBooks");
    private final static QName _DeleteBookResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "deleteBookResponse");
    private final static QName _GetLibrarianResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "getLibrarianResponse");
    private final static QName _DeleteAdmin_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "deleteAdmin");
    private final static QName _DeleteBook_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "deleteBook");
    private final static QName _GetAllBooks_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "getAllBooks");
    private final static QName _UpdateLibrarianResponse_QNAME = new QName("http://service.webservice.elibrary.apache.com/", "updateLibrarianResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.apache.elibrary.webservice.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SaveStudentBookDetailResponse }
     * 
     */
    public SaveStudentBookDetailResponse createSaveStudentBookDetailResponse() {
        return new SaveStudentBookDetailResponse();
    }

    /**
     * Create an instance of {@link SaveLibrarianResponse }
     * 
     */
    public SaveLibrarianResponse createSaveLibrarianResponse() {
        return new SaveLibrarianResponse();
    }

    /**
     * Create an instance of {@link UpdateLibrarian }
     * 
     */
    public UpdateLibrarian createUpdateLibrarian() {
        return new UpdateLibrarian();
    }

    /**
     * Create an instance of {@link UpdateBook }
     * 
     */
    public UpdateBook createUpdateBook() {
        return new UpdateBook();
    }

    /**
     * Create an instance of {@link UpdateAdminResponse }
     * 
     */
    public UpdateAdminResponse createUpdateAdminResponse() {
        return new UpdateAdminResponse();
    }

    /**
     * Create an instance of {@link DeleteAdmin }
     * 
     */
    public DeleteAdmin createDeleteAdmin() {
        return new DeleteAdmin();
    }

    /**
     * Create an instance of {@link DeleteBook }
     * 
     */
    public DeleteBook createDeleteBook() {
        return new DeleteBook();
    }

    /**
     * Create an instance of {@link GetAllBooks }
     * 
     */
    public GetAllBooks createGetAllBooks() {
        return new GetAllBooks();
    }

    /**
     * Create an instance of {@link UpdateLibrarianResponse }
     * 
     */
    public UpdateLibrarianResponse createUpdateLibrarianResponse() {
        return new UpdateLibrarianResponse();
    }

    /**
     * Create an instance of {@link GetAllIssuedBooks }
     * 
     */
    public GetAllIssuedBooks createGetAllIssuedBooks() {
        return new GetAllIssuedBooks();
    }

    /**
     * Create an instance of {@link DeleteBookResponse }
     * 
     */
    public DeleteBookResponse createDeleteBookResponse() {
        return new DeleteBookResponse();
    }

    /**
     * Create an instance of {@link GetLibrarianResponse }
     * 
     */
    public GetLibrarianResponse createGetLibrarianResponse() {
        return new GetLibrarianResponse();
    }

    /**
     * Create an instance of {@link GetLibrarians }
     * 
     */
    public GetLibrarians createGetLibrarians() {
        return new GetLibrarians();
    }

    /**
     * Create an instance of {@link GetLibrariansResponse }
     * 
     */
    public GetLibrariansResponse createGetLibrariansResponse() {
        return new GetLibrariansResponse();
    }

    /**
     * Create an instance of {@link GetAdminResponse }
     * 
     */
    public GetAdminResponse createGetAdminResponse() {
        return new GetAdminResponse();
    }

    /**
     * Create an instance of {@link GetAllBooksResponse }
     * 
     */
    public GetAllBooksResponse createGetAllBooksResponse() {
        return new GetAllBooksResponse();
    }

    /**
     * Create an instance of {@link AuthenticateAdminResponse }
     * 
     */
    public AuthenticateAdminResponse createAuthenticateAdminResponse() {
        return new AuthenticateAdminResponse();
    }

    /**
     * Create an instance of {@link SaveAdmin }
     * 
     */
    public SaveAdmin createSaveAdmin() {
        return new SaveAdmin();
    }

    /**
     * Create an instance of {@link SaveStudentBookDetail }
     * 
     */
    public SaveStudentBookDetail createSaveStudentBookDetail() {
        return new SaveStudentBookDetail();
    }

    /**
     * Create an instance of {@link AuthenticateLibrarianResponse }
     * 
     */
    public AuthenticateLibrarianResponse createAuthenticateLibrarianResponse() {
        return new AuthenticateLibrarianResponse();
    }

    /**
     * Create an instance of {@link GetBookResponse }
     * 
     */
    public GetBookResponse createGetBookResponse() {
        return new GetBookResponse();
    }

    /**
     * Create an instance of {@link GetBook }
     * 
     */
    public GetBook createGetBook() {
        return new GetBook();
    }

    /**
     * Create an instance of {@link ReturnBookFormDetailResponse }
     * 
     */
    public ReturnBookFormDetailResponse createReturnBookFormDetailResponse() {
        return new ReturnBookFormDetailResponse();
    }

    /**
     * Create an instance of {@link DeleteAdminResponse }
     * 
     */
    public DeleteAdminResponse createDeleteAdminResponse() {
        return new DeleteAdminResponse();
    }

    /**
     * Create an instance of {@link UpdateAdmin }
     * 
     */
    public UpdateAdmin createUpdateAdmin() {
        return new UpdateAdmin();
    }

    /**
     * Create an instance of {@link SaveBook }
     * 
     */
    public SaveBook createSaveBook() {
        return new SaveBook();
    }

    /**
     * Create an instance of {@link SaveLibrarian }
     * 
     */
    public SaveLibrarian createSaveLibrarian() {
        return new SaveLibrarian();
    }

    /**
     * Create an instance of {@link ElibraryException }
     * 
     */
    public ElibraryException createElibraryException() {
        return new ElibraryException();
    }

    /**
     * Create an instance of {@link SaveAdminResponse }
     * 
     */
    public SaveAdminResponse createSaveAdminResponse() {
        return new SaveAdminResponse();
    }

    /**
     * Create an instance of {@link DeleteLibrarianResponse }
     * 
     */
    public DeleteLibrarianResponse createDeleteLibrarianResponse() {
        return new DeleteLibrarianResponse();
    }

    /**
     * Create an instance of {@link GetBookAndStudentList }
     * 
     */
    public GetBookAndStudentList createGetBookAndStudentList() {
        return new GetBookAndStudentList();
    }

    /**
     * Create an instance of {@link GetBookAndStudentListResponse }
     * 
     */
    public GetBookAndStudentListResponse createGetBookAndStudentListResponse() {
        return new GetBookAndStudentListResponse();
    }

    /**
     * Create an instance of {@link AuthenticateLibrarian }
     * 
     */
    public AuthenticateLibrarian createAuthenticateLibrarian() {
        return new AuthenticateLibrarian();
    }

    /**
     * Create an instance of {@link ReturningBook }
     * 
     */
    public ReturningBook createReturningBook() {
        return new ReturningBook();
    }

    /**
     * Create an instance of {@link ReturnBookFormDetail }
     * 
     */
    public ReturnBookFormDetail createReturnBookFormDetail() {
        return new ReturnBookFormDetail();
    }

    /**
     * Create an instance of {@link UpdateBookResponse }
     * 
     */
    public UpdateBookResponse createUpdateBookResponse() {
        return new UpdateBookResponse();
    }

    /**
     * Create an instance of {@link AuthenticateAdmin }
     * 
     */
    public AuthenticateAdmin createAuthenticateAdmin() {
        return new AuthenticateAdmin();
    }

    /**
     * Create an instance of {@link SaveBookResponse }
     * 
     */
    public SaveBookResponse createSaveBookResponse() {
        return new SaveBookResponse();
    }

    /**
     * Create an instance of {@link GetAllIssuedBooksResponse }
     * 
     */
    public GetAllIssuedBooksResponse createGetAllIssuedBooksResponse() {
        return new GetAllIssuedBooksResponse();
    }

    /**
     * Create an instance of {@link GetAdmin }
     * 
     */
    public GetAdmin createGetAdmin() {
        return new GetAdmin();
    }

    /**
     * Create an instance of {@link ReturningBookResponse }
     * 
     */
    public ReturningBookResponse createReturningBookResponse() {
        return new ReturningBookResponse();
    }

    /**
     * Create an instance of {@link DeleteLibrarian }
     * 
     */
    public DeleteLibrarian createDeleteLibrarian() {
        return new DeleteLibrarian();
    }

    /**
     * Create an instance of {@link GetLibrarian }
     * 
     */
    public GetLibrarian createGetLibrarian() {
        return new GetLibrarian();
    }

    /**
     * Create an instance of {@link AdminDetail }
     * 
     */
    public AdminDetail createAdminDetail() {
        return new AdminDetail();
    }

    /**
     * Create an instance of {@link StudentDetail }
     * 
     */
    public StudentDetail createStudentDetail() {
        return new StudentDetail();
    }

    /**
     * Create an instance of {@link LibrarianDetail }
     * 
     */
    public LibrarianDetail createLibrarianDetail() {
        return new LibrarianDetail();
    }

    /**
     * Create an instance of {@link AdminEntity }
     * 
     */
    public AdminEntity createAdminEntity() {
        return new AdminEntity();
    }

    /**
     * Create an instance of {@link ViewIssuedBook }
     * 
     */
    public ViewIssuedBook createViewIssuedBook() {
        return new ViewIssuedBook();
    }

    /**
     * Create an instance of {@link BookDetail }
     * 
     */
    public BookDetail createBookDetail() {
        return new BookDetail();
    }

    /**
     * Create an instance of {@link IssueBookDetail }
     * 
     */
    public IssueBookDetail createIssueBookDetail() {
        return new IssueBookDetail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookAndStudentListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "getBookAndStudentListResponse")
    public JAXBElement<GetBookAndStudentListResponse> createGetBookAndStudentListResponse(GetBookAndStudentListResponse value) {
        return new JAXBElement<GetBookAndStudentListResponse>(_GetBookAndStudentListResponse_QNAME, GetBookAndStudentListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookAndStudentList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "getBookAndStudentList")
    public JAXBElement<GetBookAndStudentList> createGetBookAndStudentList(GetBookAndStudentList value) {
        return new JAXBElement<GetBookAndStudentList>(_GetBookAndStudentList_QNAME, GetBookAndStudentList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveAdminResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "saveAdminResponse")
    public JAXBElement<SaveAdminResponse> createSaveAdminResponse(SaveAdminResponse value) {
        return new JAXBElement<SaveAdminResponse>(_SaveAdminResponse_QNAME, SaveAdminResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteLibrarianResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "deleteLibrarianResponse")
    public JAXBElement<DeleteLibrarianResponse> createDeleteLibrarianResponse(DeleteLibrarianResponse value) {
        return new JAXBElement<DeleteLibrarianResponse>(_DeleteLibrarianResponse_QNAME, DeleteLibrarianResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "saveBook")
    public JAXBElement<SaveBook> createSaveBook(SaveBook value) {
        return new JAXBElement<SaveBook>(_SaveBook_QNAME, SaveBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveLibrarian }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "saveLibrarian")
    public JAXBElement<SaveLibrarian> createSaveLibrarian(SaveLibrarian value) {
        return new JAXBElement<SaveLibrarian>(_SaveLibrarian_QNAME, SaveLibrarian.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ElibraryException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "ElibraryException")
    public JAXBElement<ElibraryException> createElibraryException(ElibraryException value) {
        return new JAXBElement<ElibraryException>(_ElibraryException_QNAME, ElibraryException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAdminResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "deleteAdminResponse")
    public JAXBElement<DeleteAdminResponse> createDeleteAdminResponse(DeleteAdminResponse value) {
        return new JAXBElement<DeleteAdminResponse>(_DeleteAdminResponse_QNAME, DeleteAdminResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAdmin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "updateAdmin")
    public JAXBElement<UpdateAdmin> createUpdateAdmin(UpdateAdmin value) {
        return new JAXBElement<UpdateAdmin>(_UpdateAdmin_QNAME, UpdateAdmin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "getBook")
    public JAXBElement<GetBook> createGetBook(GetBook value) {
        return new JAXBElement<GetBook>(_GetBook_QNAME, GetBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnBookFormDetailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "returnBookFormDetailResponse")
    public JAXBElement<ReturnBookFormDetailResponse> createReturnBookFormDetailResponse(ReturnBookFormDetailResponse value) {
        return new JAXBElement<ReturnBookFormDetailResponse>(_ReturnBookFormDetailResponse_QNAME, ReturnBookFormDetailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "getBookResponse")
    public JAXBElement<GetBookResponse> createGetBookResponse(GetBookResponse value) {
        return new JAXBElement<GetBookResponse>(_GetBookResponse_QNAME, GetBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteLibrarian }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "deleteLibrarian")
    public JAXBElement<DeleteLibrarian> createDeleteLibrarian(DeleteLibrarian value) {
        return new JAXBElement<DeleteLibrarian>(_DeleteLibrarian_QNAME, DeleteLibrarian.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLibrarian }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "getLibrarian")
    public JAXBElement<GetLibrarian> createGetLibrarian(GetLibrarian value) {
        return new JAXBElement<GetLibrarian>(_GetLibrarian_QNAME, GetLibrarian.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAdmin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "getAdmin")
    public JAXBElement<GetAdmin> createGetAdmin(GetAdmin value) {
        return new JAXBElement<GetAdmin>(_GetAdmin_QNAME, GetAdmin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturningBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "returningBookResponse")
    public JAXBElement<ReturningBookResponse> createReturningBookResponse(ReturningBookResponse value) {
        return new JAXBElement<ReturningBookResponse>(_ReturningBookResponse_QNAME, ReturningBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllIssuedBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "getAllIssuedBooksResponse")
    public JAXBElement<GetAllIssuedBooksResponse> createGetAllIssuedBooksResponse(GetAllIssuedBooksResponse value) {
        return new JAXBElement<GetAllIssuedBooksResponse>(_GetAllIssuedBooksResponse_QNAME, GetAllIssuedBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticateAdmin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "authenticateAdmin")
    public JAXBElement<AuthenticateAdmin> createAuthenticateAdmin(AuthenticateAdmin value) {
        return new JAXBElement<AuthenticateAdmin>(_AuthenticateAdmin_QNAME, AuthenticateAdmin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "saveBookResponse")
    public JAXBElement<SaveBookResponse> createSaveBookResponse(SaveBookResponse value) {
        return new JAXBElement<SaveBookResponse>(_SaveBookResponse_QNAME, SaveBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnBookFormDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "returnBookFormDetail")
    public JAXBElement<ReturnBookFormDetail> createReturnBookFormDetail(ReturnBookFormDetail value) {
        return new JAXBElement<ReturnBookFormDetail>(_ReturnBookFormDetail_QNAME, ReturnBookFormDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "updateBookResponse")
    public JAXBElement<UpdateBookResponse> createUpdateBookResponse(UpdateBookResponse value) {
        return new JAXBElement<UpdateBookResponse>(_UpdateBookResponse_QNAME, UpdateBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticateLibrarian }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "authenticateLibrarian")
    public JAXBElement<AuthenticateLibrarian> createAuthenticateLibrarian(AuthenticateLibrarian value) {
        return new JAXBElement<AuthenticateLibrarian>(_AuthenticateLibrarian_QNAME, AuthenticateLibrarian.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturningBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "returningBook")
    public JAXBElement<ReturningBook> createReturningBook(ReturningBook value) {
        return new JAXBElement<ReturningBook>(_ReturningBook_QNAME, ReturningBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "updateBook")
    public JAXBElement<UpdateBook> createUpdateBook(UpdateBook value) {
        return new JAXBElement<UpdateBook>(_UpdateBook_QNAME, UpdateBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAdminResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "updateAdminResponse")
    public JAXBElement<UpdateAdminResponse> createUpdateAdminResponse(UpdateAdminResponse value) {
        return new JAXBElement<UpdateAdminResponse>(_UpdateAdminResponse_QNAME, UpdateAdminResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveLibrarianResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "saveLibrarianResponse")
    public JAXBElement<SaveLibrarianResponse> createSaveLibrarianResponse(SaveLibrarianResponse value) {
        return new JAXBElement<SaveLibrarianResponse>(_SaveLibrarianResponse_QNAME, SaveLibrarianResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateLibrarian }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "updateLibrarian")
    public JAXBElement<UpdateLibrarian> createUpdateLibrarian(UpdateLibrarian value) {
        return new JAXBElement<UpdateLibrarian>(_UpdateLibrarian_QNAME, UpdateLibrarian.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveStudentBookDetailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "saveStudentBookDetailResponse")
    public JAXBElement<SaveStudentBookDetailResponse> createSaveStudentBookDetailResponse(SaveStudentBookDetailResponse value) {
        return new JAXBElement<SaveStudentBookDetailResponse>(_SaveStudentBookDetailResponse_QNAME, SaveStudentBookDetailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticateLibrarianResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "authenticateLibrarianResponse")
    public JAXBElement<AuthenticateLibrarianResponse> createAuthenticateLibrarianResponse(AuthenticateLibrarianResponse value) {
        return new JAXBElement<AuthenticateLibrarianResponse>(_AuthenticateLibrarianResponse_QNAME, AuthenticateLibrarianResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveStudentBookDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "saveStudentBookDetail")
    public JAXBElement<SaveStudentBookDetail> createSaveStudentBookDetail(SaveStudentBookDetail value) {
        return new JAXBElement<SaveStudentBookDetail>(_SaveStudentBookDetail_QNAME, SaveStudentBookDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAdminResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "getAdminResponse")
    public JAXBElement<GetAdminResponse> createGetAdminResponse(GetAdminResponse value) {
        return new JAXBElement<GetAdminResponse>(_GetAdminResponse_QNAME, GetAdminResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "getAllBooksResponse")
    public JAXBElement<GetAllBooksResponse> createGetAllBooksResponse(GetAllBooksResponse value) {
        return new JAXBElement<GetAllBooksResponse>(_GetAllBooksResponse_QNAME, GetAllBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticateAdminResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "authenticateAdminResponse")
    public JAXBElement<AuthenticateAdminResponse> createAuthenticateAdminResponse(AuthenticateAdminResponse value) {
        return new JAXBElement<AuthenticateAdminResponse>(_AuthenticateAdminResponse_QNAME, AuthenticateAdminResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveAdmin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "saveAdmin")
    public JAXBElement<SaveAdmin> createSaveAdmin(SaveAdmin value) {
        return new JAXBElement<SaveAdmin>(_SaveAdmin_QNAME, SaveAdmin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLibrariansResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "getLibrariansResponse")
    public JAXBElement<GetLibrariansResponse> createGetLibrariansResponse(GetLibrariansResponse value) {
        return new JAXBElement<GetLibrariansResponse>(_GetLibrariansResponse_QNAME, GetLibrariansResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLibrarians }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "getLibrarians")
    public JAXBElement<GetLibrarians> createGetLibrarians(GetLibrarians value) {
        return new JAXBElement<GetLibrarians>(_GetLibrarians_QNAME, GetLibrarians.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllIssuedBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "getAllIssuedBooks")
    public JAXBElement<GetAllIssuedBooks> createGetAllIssuedBooks(GetAllIssuedBooks value) {
        return new JAXBElement<GetAllIssuedBooks>(_GetAllIssuedBooks_QNAME, GetAllIssuedBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "deleteBookResponse")
    public JAXBElement<DeleteBookResponse> createDeleteBookResponse(DeleteBookResponse value) {
        return new JAXBElement<DeleteBookResponse>(_DeleteBookResponse_QNAME, DeleteBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLibrarianResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "getLibrarianResponse")
    public JAXBElement<GetLibrarianResponse> createGetLibrarianResponse(GetLibrarianResponse value) {
        return new JAXBElement<GetLibrarianResponse>(_GetLibrarianResponse_QNAME, GetLibrarianResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAdmin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "deleteAdmin")
    public JAXBElement<DeleteAdmin> createDeleteAdmin(DeleteAdmin value) {
        return new JAXBElement<DeleteAdmin>(_DeleteAdmin_QNAME, DeleteAdmin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "deleteBook")
    public JAXBElement<DeleteBook> createDeleteBook(DeleteBook value) {
        return new JAXBElement<DeleteBook>(_DeleteBook_QNAME, DeleteBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "getAllBooks")
    public JAXBElement<GetAllBooks> createGetAllBooks(GetAllBooks value) {
        return new JAXBElement<GetAllBooks>(_GetAllBooks_QNAME, GetAllBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateLibrarianResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.elibrary.apache.com/", name = "updateLibrarianResponse")
    public JAXBElement<UpdateLibrarianResponse> createUpdateLibrarianResponse(UpdateLibrarianResponse value) {
        return new JAXBElement<UpdateLibrarianResponse>(_UpdateLibrarianResponse_QNAME, UpdateLibrarianResponse.class, null, value);
    }

}
