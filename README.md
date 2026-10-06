**This project is obsolete and has been archived.**

# LibCalWrapper

A web service project to pass data from LibCal to consumers.

Built as a wrapper to 1) simplify LibCal JSON structure and 2) hide LibCal source from consumers in event we switch vendors some day

Basic behavior: WS catches request, builds request for matching LibCal service, collects data from LibCal, does some data cleanup/restructuring, returns modified data to original caller.

