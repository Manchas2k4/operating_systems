/**
* LAB6
* By Victor Hugo Torres
*	A01701017
* To compile: gcc pi_thread.c -lpthread
**/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include "utils/cheader.h"
#include <time.h>

#define NUM_RECTS	1e8
#define MAXTHREADS 	4
#define TOSSES 1000000



void* task() {
	int toss;
	double x, y, distance_squared;
	int* number_in_circle = (int*) malloc(sizeof(int));
	(*number_in_circle) = 0;
	for (toss = 0; toss < TOSSES; toss++) {
		x = (double) rand() / RAND_MAX * 2.0 - 1.0;
		y = (double) rand() / RAND_MAX * 2.0 - 1.0;
		distance_squared = x * x + y * y ;
		if (distance_squared <= 1) (*number_in_circle) += 1;
	}
	pthread_exit((void*) number_in_circle);
}

int main(int arg, char* argv[]) {
	pthread_t pthread_id[MAXTHREADS];
	void* numbers_in_circles[MAXTHREADS];
	double pi;
	int i;
	int total_number_in_circle;

	for (i = 0; i < MAXTHREADS; i++) {
		pthread_create(&pthread_id[i], NULL, task, NULL);
	}

	for (i = 0; i < MAXTHREADS; i++) {
		pthread_join(pthread_id[i], &numbers_in_circles[i]);
	}

	total_number_in_circle = 0;
	for (i = 0; i < MAXTHREADS; i++) {
		total_number_in_circle += *((int*) numbers_in_circles[i]);
	}

	pi = total_number_in_circle/(double)TOSSES;
	printf("PI = %.15lf\n", pi);
	return 0;
	return 0;
}
