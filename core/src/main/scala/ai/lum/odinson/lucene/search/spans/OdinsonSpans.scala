package ai.lum.odinson.lucene.search.spans

import org.apache.lucene.search.spans.Spans
import ai.lum.odinson.lucene._

/**
 * Iterates through combinations of start/end positions per-doc.
 * Each start/end position represents a range of term positions within
 * the current document. These are enumerated in order, by increasing
 * document number, within that by increasing start position and finally
 * by increasing end position.
 *
 * (copied from lucene documentation)
 */
abstract class OdinsonSpans extends Spans {

  def span = Span(startPosition(), endPosition())

  def spanWithCaptures: SpanWithCaptures = SpanWithCaptures(span, namedCaptures)

  def width(): Int = 0

  def namedCaptures: List[NamedCapture] = Nil

  def odinDoStartCurrentDoc() = doStartCurrentDoc()

  def odinDoCurrentSpans() = doCurrentSpans()

}
