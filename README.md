# Property-based Testing

A Clojure work-through of the book
[Property-Based Testing with PropEr, Erlang, and Elixir](https://pragprog.com/book/fhproper/property-based-testing-with-proper-erlang-and-elixir)
by Fred Hebert. PBT book's [older site](https://www.propertesting.com/).

I really solidified my learning of Erlang through [Fred Hebert's
work](https://learnyousomeerlang.com/) and respect all the stuff I've seen him
put out. Although I'm not actively coding in Erlang or Elixir right now, I
thought it would be useful to buy this book and work through it, since I feel
there's something I'm not quite "getting" about property-based tests. As I
read through, I'm working through the exercises in three languages: Erlang and
Elixir (as laid out in the book) and Clojure (which I will capture here and
also the language I write in day-to-day for work).

My intent is to commit snippets in the order code appears in the book.
Theoretically, someone could then use the commit history to reproduce a
reading of the book.


## Usage

This project is built using [lein](https://leiningen.org/).

This is a test-focused project, so the main action of any real value is:
```
lein test
```


## License

Copyright © 2019 Michael S. Daines

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
