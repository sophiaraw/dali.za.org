package org.za.dali

class DateTagLib {
	def dateMedium = { attrs ->
		out << attrs.date.format('dd MMM yyyy')
	}
}
