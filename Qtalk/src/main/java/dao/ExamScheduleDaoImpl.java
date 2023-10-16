package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.ExamSchedule;
import util.MybatisSqlSessionFactory;

public class ExamScheduleDaoImpl implements ExamScheduleDao {

	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public List<ExamSchedule> getExamScheduleRounds() throws Exception {
		return sqlSession.selectList("mapper.examschedule.selectRoundList");
	}

	@Override
	public List<Object> selectedSubjectRound(String subject) throws Exception {
		return sqlSession.selectList("mapper.examschedule.selectedSubjectRound", subject);
	}
	
	// main page 
	@Override
	public List<ExamSchedule> selectSubjectSchedule() throws Exception {
		return sqlSession.selectList("mapper.examschedule.selectSubjectSchedule");
	}
	
	/*
	 * // List로 종목명을 입력받아 main info box에 들어갈 정보를 리턴
	 * 
	 * @Override public List<ExamSchedule> selectSubject(String sub) throws
	 * Exception { return sqlSession.selectList("mapper.examschedule.selectSubject")
	 * }
	 */

}