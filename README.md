# SearchSort
Single threaded search and sort algs for strings.
  
  Search algs
    -Linear search
    -Binary search (recursive)
   Sort algs
    -Quicksort  (recursive)
    -Insertion sort*
    -Bubble sort*
    
    *From my tests these seem to be non-optimal solutions.
   
   For efficiency of my algs:
   |	n  |	Bubble Sort Time (ms)	| Insertion Sort Time (ms)	| Quick Sort Time (ms)	|

		 	6	|  	1	| 		 	1	|
		 	13	|  	3	| 		 	1	|
		 	6	|  	1	| 		 	1	|
		 	11	|  	2	| 		 	1	|
		 	17	|  	3	| 		 	0	|
		 	36	|  	5	| 		 	1	|
		 	40	|  	11	| 		 	1	|
		 	49	|  	8	| 		 	1	|
		 	58	|  	10	| 		 	1	|
		 	74	|  	14	| 		 	1	|
		 	87	|  	15	| 		 	1	|
		 	111	|  	20	| 		 	2	|
		 	122	|  	21	| 		 	1	|
		 	149	|  	24	| 		 	2	|
		 	168	|  	30	| 		 	2	|
		 	197	|  	32	| 		 	1	|
		 	210	|  	36	| 		 	1	|
		 	240	|  	41	| 		 	2	|
		 	287	|  	46	| 		 	2	|
		 	317	|  	52	| 		 	2	|
		 	346	|  	57	| 		 	4	|
		 	394	|  	64	| 		 	1	|
		 	458	|  	71	| 		 	1	|
		 	484	|  	78	| 		 	2	|
		 	513	|  	86	| 		 	2	|
		 	589	|  	93	| 		 	2	|
		 	643	|  	103	| 		 	2	|
		 	695	|  	109	| 		 	2	|
		 	730	|  	117	| 		 	2	|
		 	762	|  	128	| 		 	3	|
		 	828	|  	138	| 		 	3	|
		 	902	|  	146	| 		 	3	|
		 	942	|  	157	| 		 	3	|
		 	964	|  	170	| 		 	3	|
		 	1088	|  	177	| 		 	3	|
		 	1131	|  	190	| 		 	3	|
		 	1160	|  	202	| 		 	4	|
		 	1250	|  	212	| 		 	3	|
		 	1352	|  	223	| 		 	4	|
		 	1421	|  	264	| 		 	4	|
