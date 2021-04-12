package com.passion.eclass303.homework;

import java.util.List;


public interface HomeworkMapper {
	public abstract int getAllHomeworkCount();
	public abstract int getHomeworkCount(HomeworkSelector hwSelector);
	public abstract int getHomeworkCount2(HomeworkSelector hwSelector);
	public abstract int regHomework(Homework hw);
	public abstract int updateHomework(Homework hw);
	public abstract int deleteHomework(Homework hw);
	public abstract List<Homework> getHomework(HomeworkSelector hwSelector);
	public abstract List<Homework> getHomework2(HomeworkSelector hwSelector);
	public abstract List<Homework> getSearchCategoryHomework(HomeworkSelector hwSelector);
	public abstract Homework selectHomeworkDetail(Homework hw);
}
