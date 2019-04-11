/*
 * Copyright (C) 2019 Michael Joyce
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place, Suite 330, Boston, MA 02111-1307 USA
 */

package ca.nines.alfred.cmd;

import ca.nines.alfred.entity.Corpus;
import ca.nines.alfred.entity.Report;
import ca.nines.alfred.io.CorpusReader;
import ca.nines.alfred.io.CorpusWriter;
import ca.nines.alfred.tokenizer.Tokenizer;
import ca.nines.alfred.tokenizer.WordTokenizer;
import org.apache.commons.cli.CommandLine;

/**
 * Count the words in each document and set the relevant metadata for each file.
 */
@CommandInfo(name="wc", description="Count the tokenize in the reports.")
public class WordCount extends Command {

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(CommandLine cmd) throws Exception {
        Corpus corpus = CorpusReader.read(getArgList(cmd));
        Tokenizer tokenizer = new WordTokenizer();

        for(Report report : corpus) {
            long count = tokenizer.tokenize(report.getContent()).size();
            report.setMetadata("wr.word-count", "" + count);
            tick();
        }
        reset();
        CorpusWriter.write(corpus);
    }

}
