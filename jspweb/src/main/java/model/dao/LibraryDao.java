package model.dao;

public class LibraryDao {

   // 싱글톤
   private static LibraryDao libraryDao = new LibraryDao();
   public static LibraryDao getInstance() {
      return libraryDao;
   }
   private LibraryDao() {};
   
}