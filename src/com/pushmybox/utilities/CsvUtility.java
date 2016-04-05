/**
 * 
 */
package com.pushmybox.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.pushmybox.constants.Constants;
import com.pushmybox.models.CityDetail;

/**
 * Contains functions for csv related operations using super csv
 * http://stackoverflow.com/questions/200609/can-you-recommend-a-java-library-
 * for-reading-and-possibly-writing-csv-files
 * 
 * @author pushpendra
 *
 */
public class CsvUtility {

	/**
	 * This function writes the list of cityDetail model to csv
	 * 
	 * @param cityDetailList
	 * @throws IOException
	 */
	public static void writeCsv(List<CityDetail> cityDetailList) throws IOException {
		ICsvBeanWriter beanWriter = null;
		FileWriter fileWriter = new FileWriter(Constants.CSV_FILE_NAME);
		try {
			beanWriter = new CsvBeanWriter(fileWriter, CsvPreference.STANDARD_PREFERENCE);

			// the header elements are used to map the bean values to each
			// column (names must match)
			final String[] header = new String[] { Constants.ID, Constants.NAME, Constants.TYPE, Constants.LATITUDE,
					Constants.LONGITUDE };
			final CellProcessor[] processors = getProcessors();
			// write the header
			beanWriter.writeHeader(header);

			// write the beans
			for (CityDetail cityDetail : cityDetailList) {
				beanWriter.write(cityDetail, header, processors);
			}

		} finally {
			if (beanWriter != null) {
				beanWriter.close();
			}
		}
	}

	/**
	 * Sets up the processors used for the examples. There are 10 CSV columns,
	 * so 10 processors are defined.
	 * 
	 * @return the cell processors
	 */
	private static CellProcessor[] getProcessors() {
		final CellProcessor[] processors = new CellProcessor[] { new ParseInt(), new NotNull(), new NotNull(),
				new ParseDouble(), new ParseDouble()

		};
		return processors;
	}

}
