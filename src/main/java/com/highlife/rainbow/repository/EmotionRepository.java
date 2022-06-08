//package com.highlife.rainbow.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.highlife.rainbow.domain.Emotion;
//
//public interface EmotionRepository extends JpaRepository<Emotion, Long>{
//
////	@Modifying
////    @Query("update Board b Emotion e set e.like = e.like + 1 where b.id = :id")
//    int  updateLike(@Param("id") Long id);
//	
////	@Modifying
////    @Query("update Board b Emotion e set e.angry = e.angry + 1 where b.id = :id")
//    int  updateAngry(@Param("id") Long id);
//	
////	@Modifying
////    @Query("update Board b Emotion e set e.sad = e.sad + 1 where b.id = :id")
//    int  updateSad(@Param("id") Long id);
//	
////	@Modifying
////    @Query("update Board b Emotion e set e.cheer_up = e.cheer_up + 1 where b.id = :id")
//    int  updateCheerUp(@Param("id") Long id);
//	
////	@Modifying
////    @Query("update Board b Emotion e set e.total = e.total + 1 where b.id = :id")
//    int  updateTotal(@Param("id") Long id);
//}
