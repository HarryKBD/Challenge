import numpy as np
from sklearn.metrics import accuracy_score
from matplotlib import pyplot as plt
import tensorflow as tf  
print("We're using TF", tf.__version__)


dummy = np.arange(5).astype('float32')
print(dummy)
print(dummy.shape)
print(dummy[::-1])

# with tf.name_scope("MSE"):
#     y_true = tf.placeholder("float32", shape=(None,), name="y_true")
#     y_predicted = tf.placeholder("float32", shape=(None,), name="y_predicted")
#     # Implement MSE(y_true, y_predicted), use tf.reduce_mean(...)
#     # mse = ### YOUR CODE HERE ###
#     mse = tf.reduce_mean((y_predicted - y_true) ** 2)
# def compute_mse(vector1, vector2):
#     return mse.eval({y_true: vector1, y_predicted: vector2})




y_true = tf.placeholder("float32", shape=(None,), name="y_true")
y_predicted = tf.placeholder("float32", shape=(None,), name="y_predicted")
mse = tf.reduce_mean((y_predicted - y_true) ** 2)




# tv1 = np.arange(5).astype("float32")
# tv2 = np.arange(5).astype("float32")

# with tf.Session() as sess:
#     sess.run(compute_mse(tv1, tv2))

sess = tf.Session()

a = tf.constant([10, 20,30])
b = tf.constant(10)

print(sess.run([a, b]))
print(a)
print(b)


import sklearn.metrics
for n in [1, 5, 10, 10**3]:
    elems = [np.arange(n), np.arange(n, 0, -1), np.zeros(n),
             np.ones(n), np.random.random(n), np.random.randint(100, size=n)]
    for el in elems:
        for el_2 in elems:
            true_mse = np.array(sklearn.metrics.mean_squared_error(el, el_2))
            feed_dict = {y_true: el, y_predicted: el_2}
            my_mse = sess.run([mse], feed_dict=feed_dict)
            print("true: " + str(true_mse) + "  my: " + str(my_mse))
            if not np.allclose(true_mse, my_mse):
                print('mse(%s,%s)' % (el, el_2))
                print("should be: %f, but your function returned %f" % (true_mse, my_mse))
                raise ValueError('Wrong result')


# Creating a shared variable
shared_vector_1 = tf.Variable(initial_value=np.ones(5),
                              name="example_variable", dtype=tf.int32)

sess.run(tf.global_variables_initializer())
print("Initial value", sess.run(shared_vector_1))
print(sess.run(shared_vector_1.assign(np.random.random(5))))
print(shared_vector_1)
