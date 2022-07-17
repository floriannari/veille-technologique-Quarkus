package master.veille.nari.calculs.service;

import javax.enterprise.context.ApplicationScoped;

import org.apache.commons.text.similarity.LevenshteinDistance;

@ApplicationScoped
public class CalculsServiceImpl implements CalculsService {
	private final LevenshteinDistance levenshteinDistanceInstance = LevenshteinDistance.getDefaultInstance();

	@Override
	public int levenshteinDistance(String str1, String str2) {
		return levenshteinDistanceInstance.apply(str1, str2);
	}
}
