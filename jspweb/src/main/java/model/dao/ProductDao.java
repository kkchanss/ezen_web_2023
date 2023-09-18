package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dto.ProductDto;

public class ProductDao extends Dao {

	private static ProductDao productDao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() { return productDao; }
	
	
	// 1. 제품 등록 
	public boolean register( ProductDto dto ) {
		
		// 1-1 [제품 등록] 
		try {
			
			String sql = "insert into product( pcno , pname , pcontent , pprice , plat , plng , mno  ) "
					+ "	values( ? , ? , ? , ? , ? , ? , ?  );";
			// * sql insert 후 자동생성[auto_increment]된 pk번호를 반환하는 방법 
				// conn.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS ) 	: 생성된 식별키를 반환
				// ps.getGeneratedKeys() 											: 식별키 반환하는 함수.
			ps = conn.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS ); 
			
			ps.setInt( 1 , dto.getPcno()  );		ps.setString( 2 , dto.getPname() );
			ps.setString( 3 , dto.getPcontent() );	ps.setInt( 4 , dto.getPprice() );
			ps.setString( 5 , dto.getPlat() );		ps.setString( 6 , dto.getPlng() );
			ps.setInt( 7 , dto.getMno() );
			
			int count = ps.executeUpdate();	// 제품 등록 
			
			rs = ps.getGeneratedKeys(); // 제품 등록시 생성된 식별키[pk->pno] 반환해서 resultset[ps]에 대입
			if( rs.next() ) {	// resultset  null ---next()--> 결과레코드1 --next()--> 결과레코드2 
							// 반환된 결과레코드로 1번 이동 [ 하나의 제품 식별키 필요 ]
				if( count == 1 ) { // 만약에 제품등록 1개 등록했으면 
					// 1-2 제품 등록후 생성된 제품pk를 가지고 [이미지 등록] 
						// 1. dto 에 저장된 이미지 개수만큼 insert 실행 
					for( String img : dto.getImgList().values() ) {
						sql = "insert into productimg( pimg , pno ) values( ? , ? )";
						ps = conn.prepareStatement(sql);
						ps.setString( 1 , img  );
						ps.setInt( 2 , rs.getInt( 1 ) ); // ??????????? 위에서 insert 된 제품번호 ????
						ps.executeUpdate();
					} 
					return true; // 제품등록과 이미지 등록 성공 했을때. 
				}
			}
			
		}catch (Exception e) { System.out.println( e ); } return false;
	}

	
	
	// 2. 출력 
		// 0. 제품의 해당하는 이미지 출력하는 함수 
	 public Map<Integer, String> getProductImg(int pno){
	       try {
	          Map<Integer, String> imglist = new HashMap<>();
	          String sql = "select * from productimg where pno = "+pno;
	          PreparedStatement ps2 = conn.prepareStatement(sql);
	          ResultSet rs2=ps2.executeQuery();
	          while (rs2.next()) {
	             imglist.put(rs2.getInt("pimgno"),rs2.getString("pimg"));
	          }return imglist;
	         
	      } catch (Exception e) {System.out.println(e);}return null;
	    }
	    
	    
	    public ProductDto findByPno(int pno) {
	       try {
	          ProductDto dto =new ProductDto();
	         String sql = "select * from product p natural join pcategory pc natural join member m  where pno="+pno;
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs=ps.executeQuery();
	         if(rs.next()) {
		            dto = new ProductDto(
		           rs.getInt("pcno"), rs.getString("pcname"),rs.getInt("pno"),
		           rs.getString("pname"),rs.getString("pcontent"), rs.getInt("pprice"),
		           rs.getInt("pstate"),rs.getString("pdate"),rs.getString("plat"),
		           rs.getString("plng"),rs.getInt("mno"), getProductImg(rs.getInt("pno")),
		           rs.getString("mid")
		           );
	         }return dto;
	       
	       } catch (Exception e) {System.out.println(e);}
	       return null;
	    }
	    
	       //1. N개 제품들을 최신순으로 출력하는 함수
	    public  List<ProductDto>findByTop (int count){
	       List<ProductDto> list =new ArrayList<>();
	       try {
	    	   String sql = "select * from product order by pdate desc limit ?";  
		       ps=conn.prepareStatement(sql);
		       ps.setInt(1, 10);
		       rs=ps.executeQuery();
		       while(rs.next()) {
		          
		          sql = "select * from productimg where pno = "+rs.getInt("pno");
		          
		          PreparedStatement ps2 = conn.prepareStatement(sql);
		          ResultSet rs2=ps2.executeQuery();
		          if (rs2.next()) {list.add(findByPno(rs.getInt("pno")));
		          System.out.println("list + "+ list);
		          }
		       }
		         
	      } catch (Exception e) {System.out.println(e);}
	       return list;
	    }


	    public  List<ProductDto>  findByLatLng(String east,String south,String west,String north){
	       List<ProductDto> list =new ArrayList<>();
	       System.out.println(east);
	       System.out.println(south);
	       System.out.println(west);
	       System.out.println(north);
	       try { 
	    	  String sql = "select pno from product where plat between ? and ? and plng between ?and ? order by pdate";
		      PreparedStatement ps = conn.prepareStatement(sql);
		      ps.setString(2, east);
		      ps.setString(3, south);
		      ps.setString(1, west);
		      ps.setString(4, north);
		      ResultSet rs=ps.executeQuery();
		      while (rs.next()) {list.add(findByPno(rs.getInt("pno")));}
	      }
	      
	       catch (Exception e) {System.out.println(e);}
	      
	       return list;
	    }

	      public  List<ProductDto> findByAll(){
	        List<ProductDto> list =new ArrayList<>();
	         try { 
	         String sql = "select * from product order by pdate desc";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs=ps.executeQuery();
		        while (rs.next()) {
		        	sql = "select * from productimg where pno = "+rs.getInt("pno");
			          
			          PreparedStatement ps2 = conn.prepareStatement(sql);
			          ResultSet rs2=ps2.executeQuery();
			          if (rs2.next()) {list.add(findByPno(rs.getInt("pno")));
			          System.out.println("list + "+ list);
			          }
		        }
	        }
	        
	         catch (Exception e) {System.out.println(e);}
	        
	         return list;
	      }
}

/*
 * 						// 	Map<Integer, String>			: map객체명.keySet() : map객체내 모든 키 호출 
						//	Map<Integer, String>			: map객체명.values() : map객체내 모든 값 호출 
				
						// ------ get( 인덱스 ) 	: LIST컬렉션은 인덱스 사용 
						// ------ get( 키 ) 		: SET컬렉션 MAP컬렉션은 인덱스가 없으므로 키 값으로 호출 
						// ------ 
				
 * 
 * 
 * 
 */